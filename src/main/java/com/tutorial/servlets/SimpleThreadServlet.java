package com.tutorial.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

@WebServlet("/temp")
public class SimpleThreadServlet extends HttpServlet {
    static int i = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       synchronized (this){
           for (int j = 0; j < 1000000; j++) {
               i++;
           }
           System.out.println("i =" + i );
       }
//        System.out.println(Thread.currentThread().getName());

    }

    public static void main(String[] args) {
        for (int j = 0; j < 5; j++) {
            new Thread() {
                @Override
                public void run() {
//                    String url = "";
                    try {
                        URLConnection urlConnection = new URL("http://localhost:8080/temp").openConnection();
                        urlConnection.getInputStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
