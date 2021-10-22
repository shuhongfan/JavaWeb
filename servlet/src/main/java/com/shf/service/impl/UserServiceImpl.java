package com.shf.service.impl;

import com.shf.dao.UserDao;
import com.shf.dao.impl.UserDaoImpl;
import com.shf.pojo.User;
import com.shf.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsernameUser(username)==null){
            return false;
        }
        return true;
    }
}
