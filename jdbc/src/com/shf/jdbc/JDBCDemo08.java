package com.shf.jdbc;

import com.shf.domain.Emp;
import com.shf.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo08 {
    public static void main(String[] args) {
        List<Emp> empList = new JDBCDemo08().findAll();
        for (Emp emp : empList) {
            System.out.println(emp);
        }
    }
    public List<Emp> findAll(){
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        List<Emp> list = null;
        try {
//        1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
//        2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
//        3.定义sql
            String sql="select * from emp";
//        4.获取执行sql的对象
            stmt = conn.createStatement();
//        5.执行sql
            rs = stmt.executeQuery(sql);
            Emp emp=null;
            list=new ArrayList<>();
            while (rs.next()){
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                emp=new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoin(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);
                list.add(emp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt!=null)stmt.cancel();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(rs!=null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn!=null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    public List<Emp> findAll2(){
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        List<Emp> list = null;
        try {
            conn = JDBCUtils.getConnection();
//        3.定义sql
            String sql="select * from emp";
//        4.获取执行sql的对象
            stmt = conn.createStatement();
//        5.执行sql
            rs = stmt.executeQuery(sql);
            Emp emp=null;
            list=new ArrayList<>();
            while (rs.next()){
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                emp=new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoin(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);
                list.add(emp);
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return list;
    }
}
