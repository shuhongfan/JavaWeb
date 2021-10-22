package com.shf.web;

import com.shf.pojo.Book;
import com.shf.pojo.Cart;
import com.shf.pojo.CartItem;
import com.shf.service.BookService;
import com.shf.service.impl.BookServiceImpl;
import com.shf.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);

//        获取cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null){
            cart.updateCount(id,count);
//            重定向到商品列表页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1. 获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null){
            cart.clear();
    //        重定向到商品列表页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取商品编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
//        获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null){
//            删除 了解购物车商品项
            cart.deleteItem(id);
//        重定向到商品列表页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("请求头Reference："+req.getHeader("Referer"));
//        System.out.println("加入购物车");
//        System.out.println("商品编号："+req.getParameter("id"));

//        获取请求的参数 商品编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
//        调用bookService.queryBookId(id)：book得到图书的信息
        Book book = bookService.queryBookById(id);
//        把图书信息 转换成为cartItem商品项
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
//        调用Cart.addItem(req, resp);  添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
//        记录最后添加商品名称
        req.getSession().setAttribute("lastName",cartItem.getName());
        System.out.println(cart);
//        重定向到商品列表页面
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
