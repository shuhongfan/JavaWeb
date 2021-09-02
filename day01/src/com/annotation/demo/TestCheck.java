package com.annotation.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCheck {
  public static void main(String[] args) throws IOException {
//    创建计算器对象
    Calculator c = new Calculator();
//    获取字节码对象
    Class cls = c.getClass();

//    出现异常的次数
    int number=0;
    BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));

//    获取所有方法
    Method[] methods = cls.getMethods();
    for (Method method:methods){
      //    判断方法上是否有check注解
      if (method.isAnnotationPresent(Check.class)){
        try {
          method.invoke(c);
        } catch (Exception e) {
          number++;
          bw.write(method.getName()+" 方法出现异常了");
          bw.newLine();
          bw.write("异常的名称："+e.getCause().getClass().getSimpleName());
          bw.newLine();
          bw.write("异常的原因："+e.getCause()+e.getMessage());
          bw.newLine();
          bw.write("---------------------------");
          bw.newLine();
        }
      }
    }
    bw.write("本次一共出现"+number+"此异常");
    bw.flush();
    bw.close();
  }
}
