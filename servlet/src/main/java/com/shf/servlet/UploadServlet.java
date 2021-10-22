package com.shf.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("文件上传过来了");
//        ServletInputStream inputStream = req.getInputStream();
//        byte[] bytes = new byte[1024000];
//        int read = inputStream.read(bytes);
//        System.out.println(new String(bytes,0,read));

//        1.先判断上传的数据是否多段数据  只有多段数据才是文件
        if (ServletFileUpload.isMultipartContent(req)){
//            创建fileItemFactory工厂实现类
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
//            创建用于解析上传数据的工具类ServletFileUpload类
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            //解决http报头乱码，即中文文件名乱码
            servletFileUpload.setHeaderEncoding("UTF-8");
            try {
//            解析上传的数据,得到每一个表单项FileItem
                List<FileItem> list = servletFileUpload.parseRequest(req);
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()){
//                        参数UTF8解决乱码问题
                        fileItem.getString("UTF-8");
//                        普通表单项
                        System.out.println("表单项的name属性值："+fileItem.getFieldName());
                    } else {
//                        上传的文件
                        fileItem.getString("UTF-8");
                        System.out.println("表单项的name属性值："+fileItem.getFieldName());
                        System.out.println("上传的文件名："+fileItem.getName());
                        try {
                            fileItem.write(new File("D:\\DEMO\\JavaWeb\\servlet\\src\\main\\webapp\\files\\"+fileItem.getName()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }

        }
    }
}
