package com.reflect;

import com.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectDemo4 {
  public static void main(String[] args) throws Exception {
//    获取Person的class对象
    Class personClass = Person.class;

//    获取指定名称的方法
    Method eat = personClass.getMethod("eat");
    Person p = new Person();
    eat.invoke(p);
    System.out.println("--------------------------");

//    获取指定名称 带参数的方法
    Method eat1 = personClass.getMethod("eat",String.class);
    eat1.invoke(p,"饭");
    System.out.println("--------------------------");

    Method[] methods = personClass.getMethods();
    for (Method m:methods) {
      System.out.println(m);
      String name = m.getName();
      System.out.println(name);
    }
    System.out.println("--------------------------");

//    获取类名
    String personClassName = personClass.getName();
    System.out.println(personClassName);
  }
}
