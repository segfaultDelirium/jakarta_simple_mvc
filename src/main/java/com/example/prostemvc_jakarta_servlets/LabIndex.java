package com.example.prostemvc_jakarta_servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LabIndex", value = "/LabIndex")
public class LabIndex extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<title>ZTI - Lab01</title>");
        out.println("<h1>ZTI - Lab01 : servlets and jsp scripts</h1>");
        out.println ("<ol>");
        out.println ("<li><a href='SimpleMVC'>[Servlet & JSP] Simple MVC pattern - dispatch servlet</a></li>");
        out.println ("</ol>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
