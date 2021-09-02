package com.reflect;

import com.domain.Person;

import java.lang.reflect.Field;

public class ReflectDemo2 {
  public static void main(String[] args) throws Exception {
    Class personClass = Person.class;
//    获取成员变量
//  getFields  获取所有public修饰的成员变量
    Field[] fields = personClass.getFields();
    for (Field f:fields) System.out.println(f);
    System.out.println("--------------------------");

//    getField 获取指定的public 成员变量
    Field a = personClass.getField("a");
    System.out.println(a);
    System.out.println("--------------------------");

//    获取成员变量a的值
    Person p = new Person();
    Object value = a.get(p);
    System.out.println(value);

//    设置a的值
    a.set(p,"张三");
    System.out.println(p);
    System.out.println("--------------------------");

//   getDeclaredFields() 获取所有的成员变量
    Field[] declaredFields = personClass.getDeclaredFields();
    for (Field f:declaredFields) System.out.println(f);

    Field d = personClass.getDeclaredField("d");
//    忽略访问权限修饰符的安全检查  暴力反射
    d.setAccessible(true);
    Object value2 = d.get(p);
    System.out.println(value2);
  }
}
