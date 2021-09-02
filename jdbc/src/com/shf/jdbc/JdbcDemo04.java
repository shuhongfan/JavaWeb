package com.shf.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo04 {
  public static void main(String[] args) {
    Statement stmt=null;
    Connection conn =null;
    try {
//    1.注册驱动
      Class.forName("com.mysql.jdbc.Driver");
//    2. 获取连接对象
      conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
//    3.定义sql
      String sql="delete from account where id=4";
//    4.获取执行sql对象
      stmt = conn.createStatement();
//    5.执行sql
      int count = stmt.executeUpdate(sql);
      if (count>0) System.out.println("删除成功");
      else System.out.println("删除失败");
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
