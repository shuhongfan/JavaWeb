package com.shf.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserServletTest {
    public void login(){
        System.out.println("这是login（）方法调用了");
    }

    public void regist(){
        System.out.println("这是register方法调用了");
    }

    public void upadateUser(){
        System.out.println("upadateUser方法调用");
    }

    public static void main(String[] args) {
        String action = "upadateUser";
        try {
//            通过action业务鉴别字符串,获取相应的业务 方法返回对象
            Method method = UserServletTest.class.getDeclaredMethod(action);
            System.out.println(method);

//            调用  目标业务 方法
            method.invoke(new UserServletTest());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
