package com.shf.threadlocal;

public class OrderDao {
    public void createOrderDao(){
        String name = Thread.currentThread().getName();
        System.out.println("createOrderDao当前线程["+name+"]中保存的数据是:"+ThreadLocalTest.data.get(name));
        System.out.println("createOrderDao当前线程["+name+"]中保存的数据是:"+ThreadLocalTest.threadLocal.get());
    }
}
