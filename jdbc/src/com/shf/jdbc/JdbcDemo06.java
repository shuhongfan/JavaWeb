package com.shf.jdbc;

import java.sql.*;

public class JdbcDemo06 {
  public static void main(String[] args) {
    Statement stmt=null;
    Connection conn =null;
    try {
//    1.注册驱动
      Class.forName("com.mysql.jdbc.Driver");
//    2. 获取连接对象
      conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
//    3.定义sql
      String sql="select * from account";
//    4.获取执行sql对象
      stmt = conn.createStatement();
//    5.执行sql
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()){
        int id = rs.getInt(1);
        String name = rs.getString("name");
        double balance = rs.getDouble(3);
        System.out.println(id+"-------"+name+"-------"+balance);
      }
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
