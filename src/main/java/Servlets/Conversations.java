package main.java.Servlets;

import main.java.Classes.AccountPackage.Account;
import main.java.Configs.DatabaseConnection;
import main.java.Classes.GroupPackage.Group;

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

public class Conversations extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        try{
            HttpSession sess = req.getSession();
            Statement stmt= DatabaseConnection.getConnection().createStatement();
            ResultSet rs=stmt.executeQuery("select * from Belongs");
            List<Integer> myList = new ArrayList<Integer>();
            while(rs.next())
            {
                if(rs.getInt(2)==Integer.parseInt((String)sess.getAttribute("id")))
                    myList.add(rs.getInt(1));
            }
            ResultSet ult=stmt.executeQuery("select * from Groupp");
            List<Group> secondList = new ArrayList<>();
            while(ult.next())
            {
                if(myList.contains(ult.getInt(1)))
                {
                    Group tempGroup = new Group(ult.getInt(1),ult.getString(2));
                    secondList.add(tempGroup);
                }
            }
            req.setAttribute("groups",secondList);
            req.getRequestDispatcher("AvailableConversations.jsp").forward(req, resp);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
