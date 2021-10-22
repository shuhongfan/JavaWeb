package com.shf.web;

import com.shf.pojo.User;
import com.shf.service.UserService;
import com.shf.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1. 获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

//        2.调用userService处理业务
        User login = userService.login(new User(null, username, password, null));
//        3.根据login返回返回结果判断是否登录成功
        if (login==null){
            //                失败
//            把错误信息和回显的表达项信息,保存到Request域中
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);
//                跳回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        } else {
            //                成功
//                跳转到login_succrss.html
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
