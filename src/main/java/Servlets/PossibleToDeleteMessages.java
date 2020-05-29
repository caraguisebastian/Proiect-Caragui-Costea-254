package main.java.Servlets;

import main.java.Classes.AccountPackage.Account;
import main.java.Classes.MessagePackage.Message;
import main.java.Configs.DatabaseConnection;
import main.java.Repositories.GetParticipants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PossibleToDeleteMessages extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        List<Message> mess = new ArrayList<>();
        try{
            HttpSession sess = req.getSession();
            String nickname = new String();
            Statement stmt= DatabaseConnection.getConnection().createStatement();
            ResultSet rs= stmt.executeQuery("select * from Message");
            nickname = (String)sess.getAttribute("nickname");
            while(rs.next())
            {
                if(rs.getInt(3)==Integer.parseInt(req.getParameter("groupID")) && rs.getInt(2)==Integer.parseInt((String)sess.getAttribute("id")))
                {
                    Message tempMess = new Message(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getTimestamp(4),rs.getString(5),rs.getInt(6));
                    mess.add(tempMess);
                }
            }
            req.setAttribute("nickname",nickname);
            req.setAttribute("messages",mess);
            req.setAttribute("groupdID",req.getParameter("groupdID"));
            req.getRequestDispatcher("/DeleteMessage.jsp").forward(req,resp);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
