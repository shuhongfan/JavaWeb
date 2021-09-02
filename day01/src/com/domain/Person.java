package com.domain;

public class Person {
  public String a;
  protected String b;
  String c;
  private String d;

  private String name;
  private int age;

  public void eat(){
    System.out.println("eat方法");
  }
  public void eat(String food){
    System.out.println("吃"+food);
  }

  public Person() {
  }

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person{" +
            "a=" + a +
            ", b=" + b +
            ", c=" + c +
            ", d=" + d +
            ", name='" + name + '\'' +
            ", age=" + age +
            '}';
  }
}
