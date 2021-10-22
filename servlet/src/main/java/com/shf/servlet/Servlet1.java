package com.shf.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("在Servlet1中查看材料:"+username);

//        给材料,盖章,传递到Servlet2
        request.setAttribute("key",username);

//        问路 Servlet2怎么走
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/servlet2");

//        走向Servlet2
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
