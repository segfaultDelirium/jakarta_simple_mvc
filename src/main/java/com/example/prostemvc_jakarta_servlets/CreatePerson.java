package com.example.prostemvc_jakarta_servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "CreatePerson", value = "/CreatePerson")
public class CreatePerson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("hello from doGet at /CreatePerson");

//        try {

//            Class.forName("org.postgresql.Driver");
//            String url = "jdbc:postgresql://trumpet.db.elephantsql.com:5432/vppbhvzu";
//            String username = "vppbhvzu";
//            String password = "jSQW8UyiwBWLu9xSsjYnRzV3NLU3J8Xs";
//            Connection conn = DriverManager.getConnection(url, username, password);
//            Statement stmt = conn.createStatement();
//            String sql = "INSERT INTO person (fname, lname, city) VALUES (' " +  + "', 'Abacki', 'Szczecin');       ";
//            ResultSet rs = stmt.executeQuery(sql);
//        }
//        catch (Exception e){
//            System.out.println("exception: " + e);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("hello from doPost at /CreatePerson");
    }
}
