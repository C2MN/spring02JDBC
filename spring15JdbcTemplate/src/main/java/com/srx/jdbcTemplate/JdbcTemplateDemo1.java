package com.srx.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * jdbcTemplate的基本用法
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //准备数据源 spring的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://Localhost:3306/db01");
        ds.setUsername("root");
        ds.setPassword("root");
        //1.创建jdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //给jdbcTemplate设置数据源
        jdbcTemplate.setDataSource(ds);
        //2.执行操作
        jdbcTemplate.execute("insert into account(name,money) values ('ccc','1000f')");
    }
}
