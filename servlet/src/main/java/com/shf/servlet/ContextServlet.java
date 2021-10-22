package com.shf.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.获取web.xml中配置的上下文参数context-param
        ServletContext context = getServletConfig().getServletContext();
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        System.out.println("username="+username);
        System.out.println("password="+password);

//        2.获取当前的工程路径,格式：/工程路径
        System.out.println("当前工程路径："+context.getContextPath());

//        3.获取工程部署后在服务器硬盘上的的绝对路径
        System.out.println("工程部署的路径是："+context.getRealPath("/"));
        System.out.println("css部署的路径是："+context.getRealPath("/css"));
    }
}
