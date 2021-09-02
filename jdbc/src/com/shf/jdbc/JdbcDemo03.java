package com.shf.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class JdbcDemo03 {
  public static void main(String[] args) {
    Statement stmt=null;
    Connection conn =null;
    try {
//    1.注册驱动
      Class.forName("com.mysql.jdbc.Driver");
//    2. 获取连接对象
      conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
//    3.定义sql
      String sql="update account set balance=1500 where id=3";
//    4.获取执行sql对象
      stmt = conn.createStatement();
//    5.执行sql
      int count = stmt.executeUpdate(sql);
      if (count>0) System.out.println("修改成功");
      else System.out.println("修改失败");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (stmt!=null) stmt.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      try {
        if (conn!=null) conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
