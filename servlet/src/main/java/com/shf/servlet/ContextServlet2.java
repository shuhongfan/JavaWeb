package com.shf.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        一个web工程 只有一个ServletContext对象
//        Servlet是一个域对象
        ServletContext context = getServletContext();
        System.out.println(context);
        System.out.println("Context1获取key1的值是"+context.getAttribute("key1"));
    }
}
