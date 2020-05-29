package main.java.Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import main.java.Classes.AccountPackage.Account;
import main.java.Configs.DatabaseConnection;
import main.java.Classes.FollowersPackage.Followers;

public class Follow extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        try{

            HttpSession sess = req.getSession();
            Connection con = DatabaseConnection.getConnection();
            Followers fol = new Followers(Integer.parseInt((String)sess.getAttribute("id")),Integer.parseInt(req.getParameter("acc")));
            fol.insert(con);
            req.getRequestDispatcher("/FollowComplete.jsp").forward(req,resp);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
