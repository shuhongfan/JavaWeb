package com.annotation;

public @interface MyAnno {
  int age() default 18;
  String name() default "注解";
  Person per();
  MyAnno2 anno2();
  String[] strs();
}
