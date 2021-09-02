package com.annotation;

import java.lang.annotation.*;

//元注解
//@Target 作用位置
  //ElementType.TYPE 作用在类上
  //ElementType.METHOD 作用在方法上
  //ElementType.FIELD 作用在成员变量上
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})

//@Retention 描述注解被保留的阶段
  //RetentionPolicy.RUNTIME 当前描述的注解,会保留到
//@Documented() 描述注解是否会被抽取到api文档中
//@Inherited 描述注解是否被子类继承

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno3 {

}
