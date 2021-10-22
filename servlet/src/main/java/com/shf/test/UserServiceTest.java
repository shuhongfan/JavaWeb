package com.shf.test;

import com.shf.pojo.User;
import com.shf.service.UserService;
import com.shf.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new User(null,"bbj168","666666","bbj168@qq.com"));
        userService.registerUser(new User(null,"abc168","66666","abc168@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"bbj168","666666",null)));
    }

    @Test
    public void existsUsername() {
        System.out.println(userService.existsUsername("bbj168"));
        if (userService.existsUsername("bbj168")) {
            System.out.println("用户已存在");
        } else {
            System.out.println("用户名可用");
        }
    }
}