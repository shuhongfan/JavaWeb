package com.shf.web;

import com.shf.pojo.Cart;
import com.shf.pojo.User;
import com.shf.service.OrderService;
import com.shf.service.impl.OrderServiceImpl;
import com.shf.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet{
    private OrderService orderService = new OrderServiceImpl();
//    生成订单
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取Cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
//        获取userid
        User loginUser = (User) req.getSession().getAttribute("user");
        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }

        System.out.println("orderServlet程序在["+Thread.currentThread().getName()+"]");

        Integer userId = loginUser.getId();
//        调用orderServlet.createOrder
        String orderId = orderService.createOrder(cart, userId);;

        req.setAttribute("orderId",orderId);
        req.getSession().setAttribute("orderId",orderId);

//        请求转发到/pages/cart/checkout.jsp
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }
}
