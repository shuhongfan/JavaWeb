package com.shf.dao;

import com.shf.pojo.User;

public interface UserDao {

//    根据用户名查询用户信息
    public User queryUserByUsernameUser(String username);

//    保存用户信息
    public int saveUser(User user);

//    根据用户名和密码查询用户信息
    public User queryUserByUsernameAndPassword(String username,String password);
}
