package main.java.Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import  java.io.IOException;


//@WebServlet("/test/234")
public class TestServlet extends HttpServlet {


//    public void init()
//    {
//        System.out.println("The /test/234 servlet has been initialized");
//    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        System.out.println("Got a request from myself");
//        System.out.println(req.getQueryString()); //ia ce apare dupa ?
//        resp.setHeader("Raspuns titlu", " Raspunsul efectiv");
        resp.getWriter().println("Asta apare pe site");
////       Account tempAccount = TestRepository.findByID((Integer.parseInt(req.getQueryString().split( "=")[1])));
////        resp.getWriter().println(tempAccount);
       // req.getRequestDispatcher("/test.jsp").forward(req,resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {

        resp.getWriter().println("POST POST POST");
    }

}
