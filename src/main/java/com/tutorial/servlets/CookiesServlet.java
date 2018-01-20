package com.tutorial.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookies")
public class CookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + " " + cookie.getValue());
        }
        Cookie cookie = new Cookie("myCookie", "testCookies");
        cookie.setPath("/cookies");
        cookie.setMaxAge(10);
        resp.addCookie(cookie);
        resp.setHeader("Refresh","1");
    }


}
