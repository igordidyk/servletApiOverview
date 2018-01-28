package com.tutorials.jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/logout")
public class SecureServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getSession().invalidate();
        if (req.getAttribute("javax.servlet.request.key_size") == null) {
            resp.sendRedirect("https://localhost:8443/admin");
        }

        if (req.isUserInRole("ADMIN")) {
            System.out.println("Remote User = " + req.getRemoteUser());
            System.out.println("Remote Username = " + req.getUserPrincipal().getName());
        }


    }
}
