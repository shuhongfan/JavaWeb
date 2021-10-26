package com.shf.servlet;

import com.google.gson.Gson;
import com.shf.pojo.Person;
import com.shf.pojo.PersonJson;
import com.shf.web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxServlet extends BaseServlet {
    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        System.out.println("javaScriptAjax");
        PersonJson per = new PersonJson(1, "火车");
        Gson gson = new Gson();
        String json = gson.toJson(per);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resp.getWriter().write(json);
    }


    protected void JqueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("JqueryAjax 方法被调用了");
        PersonJson person = new PersonJson(1, "康师傅");

//        json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }

    protected void jqueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jqueryGet 方法被调用了");
        PersonJson person = new PersonJson(1, "康师傅");

//        json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }

    protected void jqueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jqueryPost 方法被调用了");
        PersonJson person = new PersonJson(1, "康师傅");

//        json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }

    protected void jquerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jquerySerialize 方法被调用了");
        PersonJson person = new PersonJson(1, "康师傅");

        System.out.println("用户名："+req.getParameter("username"));
        System.out.println("密码："+req.getParameter("password"));

//        json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }
}
