package com.shf.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username+password);
        if ("admin".equals(username) && "admin".equals(password)){
            req.getSession().setAttribute("user",username);
            resp.getWriter().write("登录成功！！！");
        } else {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
