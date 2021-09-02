package com.shf.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo05 {
  public static void main(String[] args) {
    Statement stmt=null;
    Connection conn =null;
    try {
//    1.注册驱动
      Class.forName("com.mysql.jdbc.Driver");
//    2. 获取连接对象
      conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
//    3.定义sql
      String sql="create table student(id int,name varchar(20))";
//    4.获取执行sql对象
      stmt = conn.createStatement();
//    5.执行sql
      int count = stmt.executeUpdate(sql);
      System.out.println(count);

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
