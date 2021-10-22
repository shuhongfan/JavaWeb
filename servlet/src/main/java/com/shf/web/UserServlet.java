package com.shf.web;

import com.shf.pojo.User;
import com.shf.service.UserService;
import com.shf.service.impl.UserServiceImpl;
import com.shf.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    public void logout(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
//        1.销毁session中用户登录的信息 或者销毁session
        req.getSession().invalidate();
//        2.重定向到首页或登录页面
        resp.sendRedirect(req.getContextPath());
    }

    public void login(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
//        获取session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
//        删除session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //        1. 获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code");

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
//            保存用户登录的信息到session域中
            req.getSession().setAttribute("user",login);
//                跳转到login_succrss.html
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }

    public void register(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
//        获取session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
//        删除session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //        1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        Map<String, String[]> parameterMap = req.getParameterMap();
        for (Map.Entry<String,String[]> entry: parameterMap.entrySet()){
            System.out.println(entry.getKey()+"="+ Arrays.asList(entry.getValue()));
        }

//        2.检查 验证码是否正确
        if (token!=null && token.equalsIgnoreCase(code)) {
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

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//        System.out.println(action);
//        try {
////            获取action业务鉴别字符,获取响应的业务,方法反射对象
//            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
//            System.out.println(method);
////            调用目标业务方法
//            method.invoke(this,req,resp);
//        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
////        if ("register".equals(action)){
////            register(req, resp);}
////        else if ("login".equals(action)) {
////            login(req,resp);
////        }
//    }
}
