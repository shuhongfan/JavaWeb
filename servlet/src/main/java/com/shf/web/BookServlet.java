package com.shf.web;

import com.shf.pojo.Book;
import com.shf.pojo.Page;
import com.shf.service.BookService;
import com.shf.service.impl.BookServiceImpl;
import com.shf.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();

//    处理分页
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.获取请求参数 pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"),Page.PAGE_SIZE);
//        2.调用BookService.page
        Page<Book> page = bookService.page(pageNo,pageSize);
//        3.保存page对象到request域中
        req.setAttribute("page",page);
//        4.请求转发到book_manager
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.获取请求的参数   封装成为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
//        2.调用BookService.addBook()保存图书
        bookService.addBook(book);
//        3.跳转到图书列表页面
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.获取请求的参数id  图书编程
        Integer id = Integer.valueOf(req.getParameter("id"));
//        2.调用bookService.deleteBookById()删除图书
        bookService.deleteBookById(id);
//        3.重定向回图书列表管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.获取请求的参数==封装成为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
//        2.调用BookService.updateBook(book)修改图书
        bookService.updateBook(book);
//        3.重定向到图书列表管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.获取请求的参数编号
        Integer id = Integer.valueOf(req.getParameter("id"));
//        2.调用 bookService.queryBookById查询图书
        Book book = bookService.queryBookById(id);
//        3.保存图书到request域中
        req.setAttribute("book",book);
//        4.请求转发到 /pages/manager/book_edit.jsp
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.通过bookService查询全部图书
        List<Book> books = bookService.queryBooks();
//        2.把全部图书保存到request域中
        req.setAttribute("books",books);
//        3.请求转发到 /pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
}
