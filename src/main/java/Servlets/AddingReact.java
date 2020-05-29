package main.java.Servlets;

import main.java.Classes.AccountPackage.Account;
import main.java.Classes.EmotePackage.Emote;
import main.java.Classes.MEPackage.ME;
import main.java.Classes.MessagePackage.Message;
import main.java.Configs.DatabaseConnection;
import main.java.Repositories.GetParticipants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AddingReact extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        try{
            int emoteID=0;
            String s = req.getParameter("emoteName");
            s = s + ".jpeg";
            HttpSession sess = req.getSession();
            Connection con = DatabaseConnection.getConnection();
            Statement stmt= DatabaseConnection.getConnection().createStatement();
            ResultSet rs=stmt.executeQuery("select * from Emote");
            int ok = 0;
            while(rs.next())
            {
                if(s.equals(rs.getString(2)))
                {
                    emoteID = rs.getInt(1);
                    ok=1;
                    break;
                }
            }
            if(ok==1) {
                ME me = new ME(emoteID, Integer.parseInt((String) req.getParameter("messageID")), Integer.parseInt((String) req.getParameter("groupID")));
                me.insert(con);
                req.setAttribute("groupID", (String) req.getParameter("groupID"));
                req.getRequestDispatcher("/GeneratingMessages").forward(req, resp);
            }
            else
            {
                req.setAttribute("groupID", (String) req.getParameter("groupID"));
                req.getRequestDispatcher("/NotFound.jsp").forward(req, resp);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
