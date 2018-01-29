package com.tutorials.jsp;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter(value = "/mainFilter", initParams = {@WebInitParam(name = "name", value = "value")})
public class MainFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(filterConfig.getInitParameter("name"));
        System.out.println("init filter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Enumeration<String> parameterNames = request.getParameterNames();

        response.getWriter().write("before");
        chain.doFilter(request, new CustomResponseWrapper((HttpServletResponse) response));
        response.getWriter().write("after");
    }

    @Override
    public void destroy() {
        System.out.println("destroy filter");
    }
}
