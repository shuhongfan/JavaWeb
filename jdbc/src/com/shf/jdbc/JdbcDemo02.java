package com.shf.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo02 {
  public static void main(String[] args) {
    Connection conn=null;
    Statement stmt=null;
    try {
//      1. 注册驱动
      Class.forName("com.mysql.jdbc.Driver");
//      2 定义sql
      String sql="insert into account values(null,'王五',3000)";
//      3 获取connection对象
      conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
//      4. 获取执行sql的对象 statement
      stmt = conn.createStatement();
//      5. 执行sql
      int count = stmt.executeUpdate(sql);
//      6 处理结果
      if (count>0) System.out.println("添加成功！");
      else System.out.println("添加失败！");
    } catch (ClassNotFoundException | SQLException e) {
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
