package com.reflect;

import com.domain.Person;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectTest {
  public static void main(String[] args) throws Exception{
//    创建 properties对象
    Properties pro = new Properties();
//    加载配置文件 转换为一个集合
    ClassLoader classLoader = ReflectTest.class.getClassLoader();
    InputStream is = classLoader.getResourceAsStream("pro.properties");
    pro.load(is);

//    获取配置文件中定义的数据
    String className = pro.getProperty("className");
    String methodName = pro.getProperty("methodName");

//    加载该类进内存
    Class cls = Class.forName(className);

//    创建对象
    Object obj = cls.newInstance();

//    获取方法对象
    Method method = cls.getMethod(methodName);

//    执行方法
    method.invoke(obj);
  }
}
