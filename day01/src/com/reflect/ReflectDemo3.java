package com.reflect;

import com.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ReflectDemo3 {
  public static void main(String[] args) throws Exception {
//    获取Person的class对象
    Class personClass = Person.class;

//    获取构造器方法
    Constructor constructor = personClass.getConstructor(String.class, int.class);
    System.out.println(constructor);
//    创建对象
    Object person = constructor.newInstance("张三", 23);
    System.out.println(person);
    System.out.println("--------------------------");

//    获取空参构造器方法
    Constructor constructor1 = personClass.getConstructor();
    System.out.println(constructor1);
//    创建对象
    Object person1 = constructor1.newInstance();
    System.out.println(person1);

//    class.newInstance 构造方法
    Object person2 = personClass.newInstance();
    System.out.println(person2);
  }
}
