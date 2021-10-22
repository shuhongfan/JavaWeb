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

public class ClientBookServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();

    //    处理分页
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("经过了前台的ClientBookServlet程序");
//        1.获取请求参数 pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
//        2.调用BookService.page
        Page<Book> page = bookService.page(pageNo,pageSize);
        page.setUrl("client/bookServlet?action=page");
//        3.保存page对象到request域中
        req.setAttribute("page",page);
//        4.请求转发到book_manager
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    //    处理分页
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.获取请求参数 pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"),0);
        int max = WebUtils.parseInt(req.getParameter("max"),Integer.MAX_VALUE);
//        2.调用BookService.page
        Page<Book> page = bookService.pageByPrice(pageNo,pageSize,min,max);
        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
//        如果有最小价格参数 追加到分页条的地址参数中
        if (req.getParameter("min")!=null) {
            sb.append("&min=").append(req.getParameter("min"));
        }
        if (req.getParameter("max")!=null) {
            sb.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(sb.toString());
//        3.保存page对象到request域中
        req.setAttribute("page",page);
//        4.请求转发到book_manager
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
