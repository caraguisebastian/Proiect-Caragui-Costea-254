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




public class CheckUser extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        try{
            int ok=0;
            int result = 0;
            HttpSession sess = req.getSession();
            Statement stmt=DatabaseConnection.getConnection().createStatement();
            ResultSet rs=stmt.executeQuery("select * from Account");
            Account tempAcc = new Account();
            while(rs.next())
            {
                if(rs.getString(2).equals(req.getParameter("username")))
                {
                    int me = 0, otherUser=0;
                    tempAcc.setID(rs.getInt(1));
                    tempAcc.setUsername(rs.getString(2));
                    tempAcc.setNickname(rs.getString(4));
                    ResultSet ult=stmt.executeQuery("select * from Followers");
                    while(ult.next())
                    {
                        if(tempAcc.getID()==ult.getInt(1) && sess.getAttribute("id").equals(ult.getString(2)))
                        {
                            otherUser = 1;
                        }
                        if(tempAcc.getID()==ult.getInt(2) && sess.getAttribute("id").equals(ult.getString(1)))
                        {
                            me = 1;
                        }
                    }
                    if(me == 1 && otherUser == 1) result = 3;
                    else if(me == 0 && otherUser == 1) result = 1;
                    else if(me == 1 && otherUser == 0) result = 2;
                    ok=1;
                    break;
                }
            }
            if(ok==1) {
                req.setAttribute("ok",1);
                req.setAttribute("user", tempAcc);
                req.setAttribute("check", result);
                req.getRequestDispatcher("UserProfile.jsp").forward(req, resp);
            }
            else req.setAttribute("ok",0);
            req.getRequestDispatcher("UserProfile.jsp").forward(req, resp);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
