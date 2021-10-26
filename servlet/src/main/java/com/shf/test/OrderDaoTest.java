package com.shf.test;

import com.shf.dao.impl.OrderDaoImpl;
import com.shf.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDaoTest {
    @Test
    public void saveOrderDao(){
        OrderDaoImpl orderDao = new OrderDaoImpl();
        int row = orderDao.saveOrder(new Order("1234567891", new Date(), new BigDecimal(100), 0, 1));
        System.out.println(row);
    }
}
