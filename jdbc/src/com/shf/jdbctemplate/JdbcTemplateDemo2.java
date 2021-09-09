package com.shf.jdbctemplate;

import com.shf.datascource.utils.JDBCUtils;
import com.shf.domain.Emp;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo2 {
//  1.获取JDBCTemplate
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataScource());

    @Test
    public void test1(){ // 修改
//        2.定义sql
        String sql="update emp set salary=10000 where id=1001";
//        3.执行sql
        int count = template.update(sql);
        System.out.println(count);
    }

    @Test
    public void test2(){ // 添加
        String sql="insert into emp(id,ename,dept_id) values(?,?,?)";
        int count = template.update(sql, 1015, "郭靖", 10);
        System.out.println(count);
    }

    @Test
    public void test3(){  // 删除
        String sql="delete from emp where id=?";
        int count = template.update(sql, 1015);
        System.out.println(count);
    }

    @Test
    public void test4(){ // 查询 单个
        String sql="select * from emp where id=?";
        Map<String, Object> map = template.queryForMap(sql, 1001);
        System.out.println(map);
    }

    @Test
    public void test5(){ //  查询多个
        String sql="select * from emp";
        List<Map<String, Object>> list = template.queryForList(sql);
        System.out.println(list);
        for (Map<String, Object> map:list)System.out.println(map);
    }

    @Test
    public void test6(){
        String sql="select * from emp";
        List<Emp> list = template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                Emp emp = new Emp();
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoin(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);
                return emp;
            }
        });

        System.out.println(list);
    }

    @Test
    public void test7(){  // 查询所有记录 将其封装为Emp对象的List集合
        String sql="select * from emp";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp:list) System.out.println(emp);
    }

    @Test
    public void test8(){
        String sql="select count(*) from emp";
        Object total = template.queryForObject(sql,Long.class);
        System.out.println(total);
    }
}
