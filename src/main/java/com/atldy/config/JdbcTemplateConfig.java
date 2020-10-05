package com.atldy.config;

import com.atldy.utils.JDBCUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author 唐多山
 * @create 2020-09-30 9:25
 */
@Configuration
public class JdbcTemplateConfig {

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(JDBCUtil.getDataSource());
    }
}
