package com.shf.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        设置服务器字符集UTF-8
//        resp.setCharacterEncoding("utf-8");
//        通过响应头 设置浏览器字符集
//        resp.setHeader("Content-Type","text/html;charset=utf-8");

//        同时设置服务器和客户端都是用UTF-8
//        此方法一定要在获取流对象之前调用才有效
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        writer.write("武汉response's content!!!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
