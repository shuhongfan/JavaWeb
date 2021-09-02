package com.annotation;

import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Properties;

@Pro(className = "com.annotation.Demo1",methodName = "show")
public class ReflectTest {
  public static void main(String[] args) throws Exception{
//    解析注解
//    获取该类的字节码文件对象
    Class<ReflectTest> reflectTestClass = ReflectTest.class;

//    获取上面的注解对象
//    其实就在内存中生成了一个该接口的子类实现对象
//    public class ProImpl implements Pro{
//      @Override
//      public String className() {
//        return "com.annotation.Demo1";
//      }
//      @Override
//      public String methodName() {
//        return "show";
//      }
//    }
//    获取指定注解
    Pro an = reflectTestClass.getAnnotation(Pro.class);
//    调用注解对象中定义的抽象方法 获取返回值
    String className = an.className();
    String methodName = an.methodName();
    System.out.println(className+"："+methodName);

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
