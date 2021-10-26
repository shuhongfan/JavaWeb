package com.shf.service;

import com.shf.pojo.Cart;

public interface OrderService {
    public String createOrder(Cart cart,Integer userId);
}
