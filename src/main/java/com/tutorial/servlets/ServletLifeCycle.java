package com.tutorial.servlets;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/")
public class ServletLifeCycle extends HttpServlet {

   /* @Override
    public void init() throws ServletException {
        super.init();
    }*/

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("servlet init");
        System.out.println("------------------------------------------");
        System.out.println("ServletContext = " + config.getServletContext());
        System.out.println("Servlet name = " + config.getServletName());
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String element = initParameterNames.nextElement();
            System.out.println(element + " = " + config.getInitParameter(element));
        }
        System.out.println("**********************************");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("**********************************");
        System.out.println("http method = " + req.getMethod());
        resp.getWriter().write("Hello, World");
        System.out.println("**********************************");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service all requests");
        super.service(req, res);
    }


    @Override
    public void destroy() {
        System.out.println("destroy servlets");

    }
}
