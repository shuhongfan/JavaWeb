package com.shf.servlet;

import com.shf.web.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet {
//    服务器每次创建session会话的时候，都会创建一个Cookie对象。
//    这个cookie对象的key永远是：JESSIONID
//    值是新创建出来的Session的id值

     
//    session马上超时
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        先获取session对象
        HttpSession session = req.getSession();
//        让session会话马上超时  无效
        session.invalidate();

        resp.getWriter().write("当前session已经超时无效");
    }
//    session的超时指的是，客户端两次请求的最大间隔时长
    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        先获取session对象
        HttpSession session = req.getSession();
//        设置当前session3秒后超时
        session.setMaxInactiveInterval(3);

        resp.getWriter().write("当前session3后超时");
    }
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        获取了session的默认超时时长
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("session的默认超时时长为："+maxInactiveInterval+"秒");
//        session的默认时长为30分钟 1800秒
    }
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Object key1 = req.getSession().getAttribute("key1");
        resp.getWriter().write("从session中取出的key1的数据是："+key1);
    }
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().setAttribute("key1","value1");
        resp.getWriter().write("session已经保存数据");
    }

    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//         创建和获取session会话对象
        HttpSession session = req.getSession();
//        判断 当前session会话 是否是新创建出来的
        boolean isNew = session.isNew();
//        获取session会话的唯一标识id
        String id = session.getId();
        resp.getWriter().write("得到session，它的id是："+id+"<br/>");
        resp.getWriter().write("这个session是否是新创建的："+isNew);
    }
}
