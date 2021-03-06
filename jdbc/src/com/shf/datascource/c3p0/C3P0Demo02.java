package com.shf.datascource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Demo02 {
    public static void main(String[] args) throws SQLException {
////        1.DataSource 使用默认配置
//        ComboPooledDataSource ds = new ComboPooledDataSource();
////        2.获取连接
//        for (int i = 1; i <= 11; i++) {
//            Connection conn = ds.getConnection();
//            System.out.println(i+":"+conn);
//            if (i==5) conn.close();
//        }
        testNamedConfig();
    }

    public static void testNamedConfig() throws SQLException {
        //        1.DataSource 使用默认配置
        ComboPooledDataSource ds = new ComboPooledDataSource("otherc3p0");
//        2.获取连接
        for (int i = 1; i <= 11; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i+":"+conn);
        }
    }
}
