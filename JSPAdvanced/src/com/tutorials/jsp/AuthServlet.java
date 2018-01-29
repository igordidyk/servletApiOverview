package com.tutorials.jsp;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.isUserInRole("Administrator")) {
            resp.getWriter().write("user logged in as admin");
            System.out.println(req.getRemoteUser());
            System.out.println(req.getUserPrincipal());
            System.out.println(req.getRemoteUser().equals(req.getUserPrincipal().getName()));
        }
    }
}
