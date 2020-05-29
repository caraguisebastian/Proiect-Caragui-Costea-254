package main.java.Servlets;

import main.java.Classes.AccountPackage.Account;
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
import java.util.List;

public class TotalMessages extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        try{
            int total = 0;
            HttpSession sess = req.getSession();
            Statement stmt= DatabaseConnection.getConnection().createStatement();
            ResultSet rs=stmt.executeQuery("select * from Message");
            while(rs.next())
            {
                if(rs.getInt(2)==Integer.parseInt((String)sess.getAttribute("id"))) total++;

            }
            req.setAttribute("total",total);
            req.getRequestDispatcher("MyTotalMessages.jsp").forward(req, resp);

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
