package com.shf.jdbc;

import com.shf.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDemo10 {
//    事务管理
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
//        1. 获取连接
            conn = JDBCUtils.getConnection();

//            开启事务
            conn.setAutoCommit(false);


//        2.定义sql
            String sql1="update account set balance=balance-? where id=?";
            String sql2="update account set balance=balance+? where id=?";
//        3.获取执行sql对象
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
//        4.设置参数
//            张三 - 500
            pstmt1.setDouble(1,500);
            pstmt1.setInt(2,1);
//            李四 + 500
            pstmt2.setDouble(1,500);
            pstmt2.setInt(2,2);
//        5.执行sql
            pstmt1.executeUpdate();
            int i = 3 / 0;
            pstmt2.executeUpdate();

//            提交事务   所有的sql执行完成
            conn.commit();
        } catch (Exception e) {
//            事务的回滚操作
            if(conn!=null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt1,conn);
            JDBCUtils.close(pstmt2,null);
        }
    }
}
