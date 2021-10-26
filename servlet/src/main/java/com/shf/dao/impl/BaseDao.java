package com.shf.dao.impl;

import com.shf.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
//    使用DbUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

//    update方法用来执行 Insert/update/delete语句  返回-1表示失败
    public int update(String sql,Object ... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

//    查询返回一个JavaBean的sql语句
    public <T> T queryForOne(Class<T> type, String sql, Object ... args){
        Connection con = null;
        try {
            con = JdbcUtils.getConnection();
            return queryRunner.query(con,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

//    查询返回多个Java Bena的sql语句
    public <T>List<T> queryForList(Class<T> type,String sql,Object ... args){
        Connection con = null;
        try {
            con = JdbcUtils.getConnection();
            return queryRunner.query(con,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Object queryForSingleValue(String sql,Object ... args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
