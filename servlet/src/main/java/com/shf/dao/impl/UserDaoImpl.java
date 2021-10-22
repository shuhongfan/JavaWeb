package com.shf.dao.impl;

import com.shf.dao.UserDao;
import com.shf.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    public User queryUserByUsernameUser(String username) {
        String sql = "select id,username,password,email from t_user where username=?";
        return queryForOne(User.class,sql,username);
    }

    public int saveUser(User user) {
        String sql = "insert into t_user(username,password,email) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select id,username,password,email from t_user where username=? and password=?";
        return queryForOne(User.class,sql,username,password);
    }
}
