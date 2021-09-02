package com.annotation;

import java.lang.annotation.Annotation;

public class ProImpl implements Pro{

  @Override
  public String className() {
    return "com.annotation.Demo1";
  }

  @Override
  public String methodName() {
    return "show";
  }

  @Override
  public Class<? extends Annotation> annotationType() {
    return null;
  }
}
