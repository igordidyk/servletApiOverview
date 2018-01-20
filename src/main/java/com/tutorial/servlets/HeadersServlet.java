package com.tutorial.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.zip.GZIPOutputStream;

@WebServlet("/head")
public class HeadersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String element = headerNames.nextElement();
            System.out.println(element + " = " + req.getHeader(element));
        }
        if (req.getHeader("Accept-Encoding").contains("gzip")) {
            new PrintWriter(new GZIPOutputStream(resp.getOutputStream())).write("Gzip encoding");

        }
//        System.out.println("AuthType = " + req.getAuthType());
//        System.out.println("ContentLength = " + req.getContentLength());
//        System.out.println("ContentType = " + req.getContentType());
//        System.out.println("Method = " + req.getMethod());
//        System.out.println("RequestURL = " + req.getRequestURL());
//        System.out.println("RequestURI = " + req.getRequestURI());
//        System.out.println("Protocol = " + req.getProtocol());


//        resp.setHeader("Servlet-Info:","ServletAPI v3.1.0");
    }
}
