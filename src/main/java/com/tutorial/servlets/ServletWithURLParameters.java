package com.tutorial.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/param")
public class ServletWithURLParameters extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");


        resp.getWriter().write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Servlet Tutorial</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<strong>All parameters from form</strong>\n" +
                "<p>\"name = " + name + "</p>\n" +
                "<p>\"password = " + password + "</p>\n" +
                "<p>\"email = " + email + "</p>" +
                "<form action=\"/param\" method=\"post\">\n" +
                "    <input type=\"text\" name=\"name\" placeholder=\"name\">\n" +
                "    <input type=\"password\" name=\"password\" placeholder=\"password\">\n" +
                "    <input type=\"text\" name=\"email\" placeholder=\"email\">\n" +
                "    <input type=\"submit\" value=\"Send\">\n" +
                "</form>\n" +
                "\n" +
                "</body>\n" +
                "</html>");
//
        String[] emails = req.getParameterValues("email");
        for (String s : emails) {
            System.out.println(s);
        }
//
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String param = parameterNames.nextElement();
            System.out.println(param + " = " + req.getParameter(param));
        }
//
        Map<String, String[]> parameterMap = req.getParameterMap();
        System.out.println("RequestURL = " + req.getRequestURL());
        System.out.println("RequestURI = " + req.getRequestURI());
        System.out.println("ServletPath = " + req.getServletPath());
        System.out.println("RemoteHost = " + req.getRemoteHost());
        System.out.println("Locale = " + req.getLocale());
        System.out.println("LocalAddress = " + req.getLocalAddr());
        System.out.println("LocalPort = " + req.getLocalPort());
        System.out.println("LocalName = " + req.getLocalName());
        System.out.println("Locales = " + req.getLocales().toString());
        System.out.println("<!---------------------------------------------!>");
        System.out.println(req.getQueryString());
    }
//
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
