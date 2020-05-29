package main.java.Servlets;

import main.java.Configs.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class VerifyLogIn extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        Connection con = DatabaseConnection.getConnection();
        try{
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from Account");
            while(rs.next())
            {
                if(rs.getString(2).equals(req.getParameter("username")) && rs.getString(3).equals(req.getParameter("password")))
                {
                    HttpSession sess = req.getSession();
                    sess.setAttribute("id", rs.getString(1));
                    sess.setAttribute("nickname", rs.getString(4));
                    req.getRequestDispatcher("/MainPage.jsp").forward(req,resp);
                }
            }
            req.getRequestDispatcher("/LoginFailed.jsp").forward(req,resp);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
