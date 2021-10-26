package com.shf.threadlocal;

public class OrderService {
    public void createOrderService(){
        String name = Thread.currentThread().getName();
        System.out.println("OrderService当前线程["+name+"]中保存的数据是:"+ThreadLocalTest.data.get(name));
        System.out.println("OrderService当前线程["+name+"]中保存的数据是:"+ThreadLocalTest.threadLocal.get());
        new OrderDao().createOrderDao();
    }
}
