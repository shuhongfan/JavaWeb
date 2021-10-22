package com.shf.web;

import com.shf.pojo.User;
import com.shf.service.UserService;
import com.shf.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

//        2.检查 验证码是否正确
        if ("abcde".equalsIgnoreCase(code)) {
//            3.检查 用户名是否可用
            if(userService.existsUsername(username)){
//                不可用
                System.out.println("用户名[ "+username+" ]已存在");
//                回显信息,保存到request域中
                req.setAttribute("msg","用户名["+username+"]已存在");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
//                跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            } else {
//                可用
//                调用service保存到数据库
                userService.registerUser(new User(null,username,password,email));
//                跳转到注册成功页面  register_success.html
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            System.out.println("验证码["+code+"]错误");
            //                回显信息,保存到request域中
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
//            转发请求
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
