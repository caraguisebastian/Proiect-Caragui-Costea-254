package main.java.Servlets;

import main.java.Classes.AccountPackage.Account;
import main.java.Classes.EmotePackage.Emote;
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

public class WantToReact extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        List<Emote> emotes = new ArrayList<>();
        List<Message> mess = new ArrayList<>();
        List<Account> accounts = GetParticipants.getPpl(req.getParameter("groupID"));
        try{
            HttpSession sess = req.getSession();
            Statement stmt= DatabaseConnection.getConnection().createStatement();
            ResultSet rs=stmt.executeQuery("select * from Message");
            while(rs.next())
            {
                if(rs.getInt(3)==Integer.parseInt(req.getParameter("groupID")) && !(rs.getInt(2)==Integer.parseInt((String)sess.getAttribute("id"))))
                {
                    Message tempMess = new Message(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getTimestamp(4),rs.getString(5),rs.getInt(6));
                    mess.add(tempMess);
                }
            }
            rs=stmt.executeQuery("select * from Emote");
            while(rs.next())
                {
                    Emote tempEmote = new Emote(rs.getInt(1),rs.getString(2));
                    emotes.add(tempEmote);
                }
            req.setAttribute("emotes",emotes);
            req.setAttribute("accounts",accounts);
            req.setAttribute("messages",mess);
            req.setAttribute("groupdID",req.getParameter("groupdID"));
            req.getRequestDispatcher("/ChoseReact.jsp").forward(req,resp);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
