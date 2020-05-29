package main.java.Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

import main.java.Classes.AccountPackage.Account;
import main.java.Configs.DatabaseConnection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Following extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        try{
            List<Account> myList = new ArrayList<>();
            HttpSession sess = req.getSession();
            Statement stmt=DatabaseConnection.getConnection().createStatement();
            ResultSet rs=stmt.executeQuery("select * from Followers");
            while(rs.next())
            {
                if(rs.getString(1).equals(sess.getAttribute("id")))
                {
                    Statement ent=DatabaseConnection.getConnection().createStatement();
                    ResultSet ult=ent.executeQuery("select * from Account");
                    while(ult.next())
                    {
                        if(rs.getString(2).equals(ult.getString(1)))
                        {
                            Account temp = new Account(ult.getInt(1),ult.getString(2),ult.getString(3),ult.getString(4));
                            myList.add(temp);
                            break;
                        }
                    }
                }
            }
            req.setAttribute("accounts",myList);
            req.getRequestDispatcher("Following.jsp").forward(req, resp);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
