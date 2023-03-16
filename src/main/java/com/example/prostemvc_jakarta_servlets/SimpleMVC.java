package com.example.prostemvc_jakarta_servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

@WebServlet(name = "SimpleMVC", value = "/SimpleMVC")
public class SimpleMVC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("In the servlet. . .");
        // String site = request.getParameter("site");
        ServletContext sc = getServletConfig().getServletContext();
        RequestDispatcher rd = null;
        String site  = "";
        if (request.getParameterMap().containsKey("site")) {
            site = request.getParameter("site");
            System.out.println("Site parameter " + site );
        } else {
            rd = sc.getRequestDispatcher("/mvc/Home.jsp");
            rd.forward(request, response);
            return;
        }
        if ( site.equals("Site1")) {
            System.out.println("In the servlet. . . Site1");
            rd = sc.getRequestDispatcher("/mvc/Site1.jsp");
            rd.forward(request, response);
            return;
        } else if ( site.equals("ReadDatabase")) {
            System.out.println("In the servlet. . . ReadDatabase");
            rd = sc.getRequestDispatcher("/mvc/ReadDatabase.jsp");
            rd.forward(request, response);
            return;
        } else if ( site.equals("CreatePerson")) {
            System.out.println("In the servlet. . . CreatePerson");
            response.sendRedirect("CreatePersonForm.html");
            return;
        } else {
            System.out.println("In the servlet. . . Home");
            rd = sc.getRequestDispatcher("/mvc/Home.jsp");
            rd.forward(request, response);
            return;
        }
    }

    private static boolean createPerson(String fname, String lname, String city){
        try {

            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://trumpet.db.elephantsql.com:5432/vppbhvzu";
            String username = "vppbhvzu";
            String password = "jSQW8UyiwBWLu9xSsjYnRzV3NLU3J8Xs";
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO person (fname, lname, city) VALUES (' " + fname + "', '" + lname + "', '" + city + "');       ";
            boolean isSuccess = stmt.execute(sql);

            stmt.close();
            conn.close();
            return isSuccess;


        }
        catch (Exception e){
            System.out.println("exception: " + e);
        }
        return false;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher homeDispatcher = getServletConfig()
                .getServletContext()
                .getRequestDispatcher("/mvc/Home.jsp");
        if (request.getParameterMap().containsKey("site") == false) {
            homeDispatcher.forward(request, response);
            return;
        } else {
            String site = request.getParameter("site");
            if ( site.equals("CreatePerson")){
                System.out.println("hello from doPost in SimpleMVC servlet");
                Map<String, String[]> parametersMap = request.getParameterMap();
                System.out.println(parametersMap);
                boolean createdSuccessfully = createPerson(
                        parametersMap.get("fname")[0],
                        parametersMap.get("lname")[0],
                        parametersMap.get("city")[0]);
//                if(createdSuccessfully){
                if(true){
                    response.sendRedirect("SuccessfullyCreatedPerson.html");
                    return;
                }else{
                    response.sendRedirect("FailedToCreatePerson.html");
                    return;
                }
//                parametersMap.get("fname");
//                parametersMap.get("lname");
//                parametersMap.get("city");
//                response.sendRedirect("CreatePerson");
//                return;
            }
            else{
                homeDispatcher.forward(request, response);
                return;
            }
        }

    }
}
