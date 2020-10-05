package com.atldy.test;

import com.atldy.utils.JDBCUtil;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author 唐多山
 * @create 2020-09-29 16:42
 */
public class JDBCTest {

  @Test
    public void test() throws SQLException {
      Connection connection = JDBCUtil.getConnection();
      System.out.println("connection = " + connection);
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDataSource());
    System.out.println("jdbcTemplate = " + jdbcTemplate);
    List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from payment");
    System.out.println(maps.get(0));
  }

}
