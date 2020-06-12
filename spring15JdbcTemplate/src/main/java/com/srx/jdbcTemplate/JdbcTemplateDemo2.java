package com.srx.jdbcTemplate;

import com.srx.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * jdbcTemplate的CRUD操作
 */
public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate",JdbcTemplate.class);
        //3.执行操作
        //保存
        jdbcTemplate.update("insert into account(name,money) values (?,?)","eee",3333f);
        //更新
        jdbcTemplate.update("update account set name = ?,money = ? where id = ?","test",4567,7);
        //删除
        jdbcTemplate.update("delete from account where id = ?",8);
        //查询所有
        //List<Account> accountList = jdbcTemplate.query("select * from account where money > ?",new AccountRowMapper(),1000f);
        List<Account> accountList = jdbcTemplate.query("select * from account where money > ?",new BeanPropertyRowMapper<Account>(Account.class),1000f);
        for (Account account: accountList) {
            System.out.println(account);
        }
        //查询一个 实际开发中常用
        List<Account> accounts = jdbcTemplate.query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),1);
        System.out.println(accounts.isEmpty()?"没有内容":accounts.get(0));
        //查询返回一行一列（使用聚合函数，但不加group by子句）
        Long count = jdbcTemplate.queryForObject("select count(*) from account where money > ?",Long.class,1000f);
        System.out.println(count);
    }
}

/**
 * 定义account的封装策略
 */
class AccountRowMapper implements RowMapper<Account>{

    /**
     * 把结果集中的数据封装到Account中，然后由spring把每个Account加到集合中
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}
