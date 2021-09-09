package com.shf.datascource.druid;

import com.shf.datascource.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DruidDemo2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
//        完成添加操作
        try {
//        1.获取连接
            conn = JDBCUtils.getConnection();
//            2.定义sql
            String sql="insert into account values(null,?,?)";
//            3.获取pstmt对象
            pstmt = conn.prepareStatement(sql);
//            4.给？赋值
            pstmt.setString(1,"王五");
            pstmt.setDouble(2,3000);
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt,conn);
        }
    }
}
