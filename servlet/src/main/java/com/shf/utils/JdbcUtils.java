package com.shf.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

    static {
        Properties properties = new Properties();
        try {
//            读取jdbc.properties
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
//            从流中读取数据
            properties.load(inputStream);
//            创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    获取数据库连接池中的连接
    public static Connection getConnection(){
        Connection conn = conns.get();
        if (conn == null) {
            try {
//                从数据库连接池中获取连接
                conn = dataSource.getConnection();
//                添加到ThreadLocal对象中,供后面的JDBC操作使用
                conns.set(conn);
//                设置为手动管理事物
                conn.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

//    提交事物,并关闭释放连接
    public static void commitAndClose(){
        Connection connection = conns.get();
//        如果不等于null 说明之前使用过连接 操作过数据库
        if (connection!=null){
            try {
//                提交事物
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
//                    关闭连接
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
//        一定要执行remove操作 否则就会出错  因为Tomcat服务器底层使用了线程技术
//        每次使用完一个连接后，在close的时候都要让当前线程与连接解绑
        conns.remove();
    }
    //    回滚事务,并关闭释放连接
    public static void rollbackAndClose(){
        Connection connection = conns.get();
//        如果不等于null 说明之前使用过连接 操作过数据库
        if (connection!=null){
            try {
//                回滚事物
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
//                    关闭连接
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
//        一定要执行remove操作 否则就会出错  因为Tomcat服务器底层使用了线程技术
        conns.remove();
    }

//    关闭连接  放回数据库连接池
    public static void close(Connection conn){
        if (conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
