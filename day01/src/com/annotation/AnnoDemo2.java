package com.annotation;

//  压制所有的警告
@SuppressWarnings("all")
public class AnnoDemo2 {
  @Override
  public String toString(){
    return super.toString();
  }

//  过时的方法
  @Deprecated
  public void show1(){

  }

//  压制所有的警告
//  @SuppressWarnings("all")

  @MyAnno(age = 1,name = "ss",per=Person.P1,anno2 = @MyAnno2,strs={"1","2"})
  public void show2(){

  }
  public void demo(){
    show1();

  }
}
