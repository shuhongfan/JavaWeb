package com.shf.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


//DriverManager 驱动管理对象  注册驱动 获取数据库连接
//Connection 数据库连接对象
//Statement  执行sql对象
public class JdbcDemo01 {
  public static void main(String[] args) throws Exception{
//    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "root");
    String sql="update account set balance=500 where id=1";
    Statement statement = conn.createStatement();
    int count = statement.executeUpdate(sql);
    System.out.println(count);
    statement.close();
    conn.close();
  }
}
