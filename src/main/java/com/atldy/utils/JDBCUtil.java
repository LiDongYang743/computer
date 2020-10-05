package com.atldy.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author 唐多山
 * @create 2020-09-29 16:12
 */
public class JDBCUtil {

    private static DataSource dataSource;

    //   1、初始化连接池
    static {
        try {
            Properties pro = new Properties();
            InputStream in = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(in);
            dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  2、获取数据库连接
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

    //    3、获取连接池
    public static DataSource getDataSource() {
        return dataSource;
    }

//    获取jdbcTemplate
    public static JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(dataSource);
    }

    // 4.定义关闭资源的方法
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }

    // 5.重载关闭方法
    public static void close(Connection conn, Statement stmt) {
        close(conn, stmt, null);
    }

}
