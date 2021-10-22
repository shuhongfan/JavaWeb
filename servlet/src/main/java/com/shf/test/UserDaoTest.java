package com.shf.test;

import com.shf.dao.impl.UserDaoImpl;
import com.shf.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDaoImpl userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsernameUser() {
        if(userDao.queryUserByUsernameUser("admin")==null){
            System.out.println("用户名可用!!!");
        } else  {
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void saveUser() {
        if (userDao.queryUserByUsernameAndPassword("admin","admin")==null){
            System.out.println("用户名或密码错误,登录失败!!!");
        } else{
            System.out.println("查询成功");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        System.out.println(userDao.saveUser(new User(null,"admin","123456","admin@qq.com")));
    }
}