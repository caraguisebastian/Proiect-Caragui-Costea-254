package main.java.Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

import main.java.Classes.AccountPackage.Account;
import main.java.Configs.DatabaseConnection;


public class Register extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        Connection con = DatabaseConnection.getConnection();
        Account acc = new Account(0, req.getParameter("username"),req.getParameter("password"), req.getParameter("nickname"));
        try{

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from Account");
            while(rs.next())
            {
                if(rs.getString(2).equals(acc.getUsername()))
                   {
                       rs.close();
                       stmt.close();
                       req.getRequestDispatcher("/RegistrationFailed.jsp").forward(req,resp);
                   }
            }
            rs.close();
            acc.insert(con);
            req.getRequestDispatcher("/RegistrationComplete.jsp").forward(req,resp);
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
