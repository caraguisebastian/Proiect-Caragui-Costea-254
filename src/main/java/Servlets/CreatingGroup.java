package main.java.Servlets;

import main.java.Classes.AccountPackage.Account;
import main.java.Configs.DatabaseConnection;
import main.java.Repositories.DoesHeExist;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreatingGroup extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        Connection con = DatabaseConnection.getConnection();
        try{
            HttpSession sess = req.getSession();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO Groupp VALUES(null,?)");
            pstmt.setString(1,(req.getParameter("groupName")));
            pstmt.executeUpdate();
            Statement stmt=DatabaseConnection.getConnection().createStatement();
            ResultSet rs=stmt.executeQuery("select * from Groupp");
            String s = req.getParameter("groupName");
            int id=0;
            while (rs.next())
            {
                if(s.equals(rs.getString(2)))
                {
                    id=rs.getInt(1);
                    break;
                }
            }
            int a=0;
            pstmt = con.prepareStatement("INSERT INTO Belongs VALUES(?,?)");
            pstmt.setInt(1,id);
            pstmt.setInt(2,Integer.parseInt((String)sess.getAttribute("id")));
            pstmt.executeUpdate();
            a = DoesHeExist.exists(req.getParameter("username1"));
            if(a!=0 && a!=Integer.parseInt((String)sess.getAttribute("id")))
            {
                pstmt.setInt(1,id);
                pstmt.setInt(2,a);
                pstmt.executeUpdate();
            }
            a = DoesHeExist.exists(req.getParameter("username2"));
            if(a!=0 && a!=Integer.parseInt((String)sess.getAttribute("id")))
            {
                pstmt.setInt(1,id);
                pstmt.setInt(2,a);
                pstmt.executeUpdate();
            }
            a = DoesHeExist.exists(req.getParameter("username3"));
            if(a!=0 && a!=Integer.parseInt((String)sess.getAttribute("id")))
            {
                pstmt.setInt(1,id);
                pstmt.setInt(2,a);
                pstmt.executeUpdate();
            }
            a = DoesHeExist.exists(req.getParameter("username4"));
            if(a!=0 && a!=Integer.parseInt((String)sess.getAttribute("id")))
            {
                pstmt.setInt(1,id);
                pstmt.setInt(2,a);
                pstmt.executeUpdate();
            }
            a = DoesHeExist.exists(req.getParameter("username5"));
            if(a!=0 && a!=Integer.parseInt((String)sess.getAttribute("id")))
            {
                pstmt.setInt(1,id);
                pstmt.setInt(2,a);
                pstmt.executeUpdate();
            }
            a = DoesHeExist.exists(req.getParameter("username6"));
            if(a!=0 && a!=Integer.parseInt((String)sess.getAttribute("id")))
            {
                pstmt.setInt(1,id);
                pstmt.setInt(2,a);
                pstmt.executeUpdate();
            }
            a = DoesHeExist.exists(req.getParameter("username7"));
            if(a!=0 && a!=Integer.parseInt((String)sess.getAttribute("id")))
            {
                pstmt.setInt(1,id);
                pstmt.setInt(2,a);
                pstmt.executeUpdate();
            }
            a = DoesHeExist.exists(req.getParameter("username8"));
            if(a!=0 && a!=Integer.parseInt((String)sess.getAttribute("id")))
            {
                pstmt.setInt(1,id);
                pstmt.setInt(2,a);
                pstmt.executeUpdate();
            }
            a = DoesHeExist.exists(req.getParameter("username9"));
            if(a!=0 && a!=Integer.parseInt((String)sess.getAttribute("id")))
            {
                pstmt.setInt(1,id);
                pstmt.setInt(2,a);
                pstmt.executeUpdate();
            }

            req.getRequestDispatcher("GroupCreated.jsp").forward(req,resp);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
