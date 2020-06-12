package com.srx.test;

import com.srx.domain.Account;
import com.srx.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用junit单元测试，测试我们的配置
 */
public class AccountServiceTest {
    @Test
    public void testFindAllAccount() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务曾对象
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        //3.执行方法
        List<Account> accounts = accountService.findAllAccount();
        for (Account account:accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindAccountById() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务曾对象
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        //3.执行方法
        Account account = accountService.findAccountById(1);
        System.out.println("testFindAccountById:"+account);
    }

    @Test
    public void testSaveAccount() {
        Account account = new Account();
        account.setName("Test");
        account.setMoney(13200f);
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务曾对象
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        //3.执行方法
        accountService.saveAccount(account);
    }

    @Test
    public void testUpdateAccount() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务曾对象
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        //3.执行方法
        Account account = accountService.findAccountById(4);
        account.setName("woAiNi");
        accountService.updateAccount(account);
    }

    @Test
    public void testDeleteAccount() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务曾对象
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        //3.执行方法
        accountService.deleteAccount(4);
    }
}
