package com.shf.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet  implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("inti");
        System.out.println("HelloServlet程序的别名是："+servletConfig.getServletName());
        System.out.println("初始化参数username的值为："+servletConfig.getInitParameter("username"));
        System.out.println("初始化参数password]的值为："+servletConfig.getInitParameter("password"));
        System.out.println(servletConfig.getServletContext());
    }

    public ServletConfig getServletConfig() {
        return null;
    }

//    service处理请求和相应的方法
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        System.out.println(method);

        if ("GET".equals(method)) {
            doGet();
        } else if ("POST".equals(method)){
            doPost();
        }

    }
    public void doGet(){
        System.out.println("GET请求");
    }
    public void doPost(){
        System.out.println("POST请求");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {
        System.out.println("destroy");
    }
}
