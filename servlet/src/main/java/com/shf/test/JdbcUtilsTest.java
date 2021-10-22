package com.shf.test;

import com.shf.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils(){
        Connection conn = JdbcUtils.getConnection();
        JdbcUtils.close(conn);
    }
}
