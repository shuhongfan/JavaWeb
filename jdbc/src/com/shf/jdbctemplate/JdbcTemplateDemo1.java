package com.shf.jdbctemplate;

import com.shf.datascource.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
//    1.导入jar包
//    2.创建JDBCTemplate
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataScource());
    //        3调用方法
        String sql="update account set balance=5000 where id = ?";
        int count = template.update(sql, 3);
        System.out.println(count);
    }
}
