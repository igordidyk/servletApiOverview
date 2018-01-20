package com.tutorial.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/xss")
public class CrossSiteScriptingServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        message = message == null ? "" : message.replaceAll("<", "&lt").replaceAll(">", "&gt");

        resp.getWriter().write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Servlet Tutorial</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p>\"message = " + message + "</p>" +
                "<form action=\"/xss\" method=\"post\">\n" +
                "    <textarea type=\"text\" name=\"message\"></textarea>" +
                "    <input type=\"submit\" value=\"Send\">\n" +
                "</form>\n" +
                "\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
