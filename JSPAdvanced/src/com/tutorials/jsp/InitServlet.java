package com.tutorials.jsp;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class InitServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("initialize servlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("init servlet");

        Enumeration<String> initParameterNames = getServletConfig().getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String param = initParameterNames.nextElement();
            System.out.println(param + " = " + getServletConfig().getInitParameter(param));
        }

        System.out.println(getServletContext().getInitParameter("email"));
    }
}
