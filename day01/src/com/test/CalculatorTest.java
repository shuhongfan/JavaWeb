package com.test;

import com.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
//  初始化方法 用于资源的申请
  @Before
  public void init(){
    System.out.println("init...");
  }
//  释放资源方法
  @After
  public void close(){
    System.out.println("close...");
  }

  @Test
  public void testAdd(){
    System.out.println("testadd");
    Calculator c=new Calculator();
    int result = c.add(1, 2);
    System.out.println(result);

    Assert.assertEquals(3,result);
  }
  @Test
  public void testSub(){
    Calculator calculator = new Calculator();
    int result = calculator.sub(1, 2);
    System.out.println("testsub");
    Assert.assertEquals(-1,result);
  }
}
