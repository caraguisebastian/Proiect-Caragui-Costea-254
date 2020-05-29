package main.java.Servlets;

import main.java.Classes.FollowersPackage.Followers;
import main.java.Classes.MessagePackage.Message;
import main.java.Configs.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Timestamp;

public class SendMessage extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        try{

            HttpSession sess = req.getSession();
            Connection con = DatabaseConnection.getConnection();
            Message mess = new Message(0,
                    Integer.parseInt((String)sess.getAttribute("id")),
                    Integer.parseInt((String)req.getParameter("groupID")),
                    new Timestamp(System.currentTimeMillis()),
                    req.getParameter("message"),
                    Integer.parseInt((String)req.getParameter("messageID")));
            mess.insert(con);
            req.setAttribute("groupID",(String)req.getParameter("groupID"));
            req.getRequestDispatcher("/GeneratingMessages").forward(req,resp);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
