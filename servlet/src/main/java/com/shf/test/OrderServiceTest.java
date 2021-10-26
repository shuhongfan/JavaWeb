package com.shf.test;

import com.shf.dao.impl.OrderItemDaoImpl;
import com.shf.pojo.Cart;
import com.shf.pojo.CartItem;
import com.shf.pojo.OrderItem;
import com.shf.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"数据结构与算法",1,new BigDecimal(100),new BigDecimal(100)));

        OrderServiceImpl orderService = new OrderServiceImpl();
        String serviceOrder = orderService.createOrder(cart, 1);
        System.out.println(serviceOrder);
    }
}