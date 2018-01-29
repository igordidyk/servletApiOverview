package com.tutorials.jsp;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;


public class CustomResponseWrapper extends HttpServletResponseWrapper {

    public CustomResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        System.out.println("custom getWriter()");
        return super.getWriter();
    }
}
