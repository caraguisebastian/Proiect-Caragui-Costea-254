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

public class GroupMenu extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        try{
            List<Account> myList = new ArrayList<>();
            HttpSession sess = req.getSession();
            Statement stmt= DatabaseConnection.getConnection().createStatement();
            ResultSet rs=stmt.executeQuery("select * from Account");
            while(rs.next())
            {
                if(!(rs.getString(1).equals(sess.getAttribute("id"))))
                {
                    Account temp = new Account(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
                    myList.add(temp);
                }
            }
            req.setAttribute("users",myList);
            req.getRequestDispatcher("CreateGroup.jsp").forward(req, resp);

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
