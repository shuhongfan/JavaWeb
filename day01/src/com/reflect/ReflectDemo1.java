package com.reflect;

import com.domain.Person;
import com.domain.Student;

public class ReflectDemo1 {
  public static void main(String[] args) throws ClassNotFoundException {
//    获取字节码的三种方式
//    Class.forName("全类名")  多用于配置文件
    Class cls1 = Class.forName("com.domain.Person");
    System.out.println(cls1);

//    类名.class   多用于参数传递
    Class cls2 = Person.class;
    System.out.println(cls2);

//    对象.getClass（）  多用于对象获取字节码的方式
    Person p = new Person();
    Class cls3 = p.getClass();
    System.out.println(cls3);

    System.out.println(cls1==cls2);
    System.out.println(cls1==cls3);
    System.out.println(cls2==cls3);

    Class stuClass = Student.class;
    System.out.println(cls1==stuClass);
  }
}
