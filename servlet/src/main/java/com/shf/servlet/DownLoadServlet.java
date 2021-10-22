package com.shf.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

public class DownLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取要下载的文件名
        String downLoadFileName="时间.jpg";
//        读取要下载的文件内容
        ServletContext servletContext = getServletContext();
//        在回传前,通过响应头告诉客户端返回的数据类型
        String mimeType = servletContext.getMimeType("/files/" + downLoadFileName);
        System.out.println("下载的文件类型："+mimeType);
        resp.setContentType(mimeType);
//        还要告诉客户端收到的数据是用于下载使用
        resp.setHeader("Content-Disposition","attachment; filename="+ URLEncoder.encode(downLoadFileName,"UTF-8"));

//        把下载的文件内容回传给客户端
        InputStream resourceAsStream = servletContext.getResourceAsStream("/files/" + downLoadFileName);
//        获取响应的输出流
        ServletOutputStream outputStream = resp.getOutputStream();
//        读取输入流中全部的数据,复制给输出流,输出给客户端
        IOUtils.copy(resourceAsStream,outputStream);
    }
}
