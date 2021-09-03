package com.shf.jdbc;

import com.shf.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCDemo9 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入用户名:");
    String username = scanner.next();
    System.out.println("请输入密码：");
    String password = scanner.next();
    boolean isLogin = login(username, password);
    if (isLogin) System.out.println("登录成功");
    else System.out.println("登录失败");
  }
//  登录方法
  public static boolean login(String username,String password){
    if (username==null || password==null) return false;
//    1.获取数据库连接
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
      conn = JDBCUtils.getConnection();
//    2.定义sql
      String sql="select * from user where username='"+username+"' and password='"+password+"'";
//    3.获取执行sql对象
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);
//      if (rs.next()) return true;
//      else return false;
      return rs.next();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.close(rs,stmt,conn);
    }
    return false;
  }
}
