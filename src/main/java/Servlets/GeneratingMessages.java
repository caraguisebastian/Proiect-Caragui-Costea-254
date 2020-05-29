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

public class GeneratingMessages extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        List<Message> mess = new ArrayList<>();
        List<Account> accounts = GetParticipants.getPpl(req.getParameter("groupID"));
        try{
            Statement stmt= DatabaseConnection.getConnection().createStatement();
            ResultSet rs=stmt.executeQuery("select * from Message");
            while(rs.next())
            {
                if(rs.getInt(3)==Integer.parseInt(req.getParameter("groupID")))
                {
                    Message tempMess = new Message(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getTimestamp(4),rs.getString(5),rs.getInt(6));
                    mess.add(tempMess);
                }
            }
            req.setAttribute("groupID",(String)req.getParameter("groupID"));
            req.setAttribute("users",accounts);
            req.setAttribute("mess",mess);
            req.getRequestDispatcher("ChatHead.jsp").forward(req, resp);

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
