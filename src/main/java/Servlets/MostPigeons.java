package main.java.Servlets;

import main.java.Configs.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostPigeons extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        try{
            List<Integer> groupIDs= new ArrayList<>();
            HttpSession sess = req.getSession();
            Statement stmt= DatabaseConnection.getConnection().createStatement();
            ResultSet rs=stmt.executeQuery("select * from Belongs");
            while(rs.next())
            {
                if(rs.getInt(2)==Integer.parseInt((String)sess.getAttribute("id"))) groupIDs.add(rs.getInt(1));
            }
            if(groupIDs.size()==0) {
                String s = "Get in a group bro...";
                req.setAttribute("favorite",s);
                req.getRequestDispatcher("FavoriteGroup.jsp").forward(req,resp);
            }
            else {
                int[] totalMessages = new int[groupIDs.size()];
            rs=stmt.executeQuery("select * from Message");
            while(rs.next())
            {
                if(rs.getInt(2)==Integer.parseInt((String)sess.getAttribute("id")))
                {
                    for(int i = 0; i < groupIDs.size(); i++)
                        if(rs.getInt(1)==groupIDs.get(i))
                        {
                            totalMessages[i]++;
                            break;
                        }
                }
            }
            int favoriteGroup = 0;
            int max = Arrays.stream(totalMessages).max().getAsInt();
            for(int i = 0; i < groupIDs.size(); i++)
            {
                if(totalMessages[i]==max)
                {
                    favoriteGroup=groupIDs.get(i);
                    break;
                }
            }
            String groupName = new String();
            rs=stmt.executeQuery("select * from Groupp");
            while(rs.next())
            {
                if(rs.getInt(1)==favoriteGroup)
                {
                    groupName=rs.getString(2);
                    break;
                }
            }
            req.setAttribute("favorite",groupName);
            req.getRequestDispatcher("FavoriteGroup.jsp").forward(req,resp);}
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
