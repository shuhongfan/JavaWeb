package com.shf.service;

import com.shf.pojo.User;

public interface UserService {
//    注册用户
    public void registerUser(User user);

//    登录
    public User login(User user);

//    检查用户名是否可用
    public boolean existsUsername(String username);
}
