package com.shf.jdbc;

import com.shf.util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

public class JDBCDemo09 {
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

  //  登录方法 PreparedStatement
  public static boolean login2(String username,String password){
    if (username==null || password==null) return false;
//    1.获取数据库连接
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      conn = JDBCUtils.getConnection();
//    2.定义sql
      String sql="select * from user where username=? and password=?";
//    3.获取执行sql对象
      pstmt = conn.prepareStatement(sql);
//      给？赋值
      pstmt.setString(1,username);
      pstmt.setString(2,password);
//      4. 执行查询,不需要传递sql
      rs = pstmt.executeQuery();
//      if (rs.next()) return true;
//      else return false;
      return rs.next();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.close(rs,pstmt,conn);
    }
    return false;
  }

//  登录方法 createStatement
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
//      4.执行查询
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
