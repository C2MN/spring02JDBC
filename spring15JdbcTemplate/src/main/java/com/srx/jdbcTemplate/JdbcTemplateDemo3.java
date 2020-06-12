package com.srx.jdbcTemplate;

import com.srx.dao.IAccountDao;
import com.srx.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * jdbcTemplate的基本用法
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountDao accountDao = applicationContext.getBean("accountDao",IAccountDao.class);
        //3.执行方法
        Account account = accountDao.findAccountById(4);
        System.out.println("账户信息："+account.getName()+":"+account.getMoney());

        Account account1 = accountDao.findAccountByName("aaa");
        System.out.println("账户信息："+account1.getName()+":"+account1.getMoney());

        Account account2 = new Account();
        account2.setName("fff");
        account2.setMoney(2000f);
        accountDao.updateAccount(account2);

    }
}