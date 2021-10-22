package com.shf.servlet;

import com.shf.utils.CookieUtils;
import com.shf.web.BaseServlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {
    protected void testPath(HttpServletRequest req,HttpServletResponse resq) throws IOException {
        Cookie cookie = new Cookie("path1","path1");
        cookie.setPath(req.getContextPath()+"/abc");
        resq.addCookie(cookie);
        resq.getWriter().write("创建一个带有Path路径的Cookie");
    }

    protected void left3600(HttpServletRequest req,HttpServletResponse resq) throws IOException {
        Cookie cookie = new Cookie("left3600", "left3600");
        //        设置存活时间
        cookie.setMaxAge(3600);
        resq.addCookie(cookie);

        resq.getWriter().write("left3600已经设置1小时存活");
    }

    protected void deleteNow(HttpServletRequest req,HttpServletResponse resq) throws IOException {
        Cookie key1 = CookieUtils.findCookie("key1", req.getCookies());
        if (key1 != null){
            Cookie cookie = new Cookie("defaultLife", "defaultLife");
    //        设置存活时间
            cookie.setMaxAge(0);
            resq.addCookie(cookie);

            resq.getWriter().write("key1的cookie已经被删除");
        }
    }

    protected void defaultLife(HttpServletRequest res,HttpServletResponse resq){
        Cookie cookie = new Cookie("defaultLife", "defaultLife");
//        设置存活时间
        cookie.setMaxAge(-1);
        resq.addCookie(cookie);
    }

    protected void updateCookie(HttpServletRequest request,HttpServletResponse response) throws IOException {
//        方案1
//        1.先创建一个要修改的同名cookie
//        2. 造构造器 同时赋值与新的cookie值
//        Cookie cookie = new Cookie("key1", "newVal1");
//        3.调用response.addCookie() 通知客户端保存修改
//        response.addCookie(cookie);

//        方案2
//        1.查找需要修改的cookie对象
        Cookie c1 = CookieUtils.findCookie("key1", request.getCookies());
        if (c1 != null) {
//        2.调用setValue方法赋值新的cookie值
            c1.setValue("newVal222");
//        3.调用response.addCookie通知客户端保存修改
            response.addCookie(c1);
        }
        response.getWriter().write("key1的cookie已经修改好了");
    }

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        中文乱码
        req.setCharacterEncoding("UTF-8");

//        1.创建Cookie对象
        Cookie cookie = new Cookie("key1","value1");
//        2.通知客户端保存cookie
        resp.addCookie(cookie);
//        3.页面显示cookie
        resp.getWriter().write("cookie创建成功");
    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            resp.getWriter().write("cookie[ "+cookie.getName() + " ] = "+cookie.getValue()+"<br/>");
        }

        Cookie iWantCookie = null;
        for (Cookie cookie : cookies) {
            if ("key1".equals(cookie.getName())){
                iWantCookie = cookie;
                break;
            }
        }
        if (iWantCookie != null){
            resp.getWriter().write("找到了需要的cookie");
        }

        Cookie key1 = CookieUtils.findCookie("key1", cookies);
        System.out.println(key1);
    }
}
