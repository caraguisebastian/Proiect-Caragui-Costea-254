package main.java.Servlets;

import main.java.Classes.MessagePackage.Message;
import main.java.Configs.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeletingMessage extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        try{
            PreparedStatement stmt= DatabaseConnection.getConnection().prepareStatement("DELETE FROM MESSAGE WHERE ID = ?");
            stmt.setInt(1,Integer.parseInt((String)req.getParameter("messageID")));
            stmt.executeUpdate();

            req.setAttribute("groupdID",req.getParameter("groupdID"));
            req.getRequestDispatcher("/GeneratingMessages").forward(req,resp);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
