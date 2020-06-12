package com.srx.test;

import com.srx.domain.Account;
import com.srx.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

/**
 * 使用junit单元测试，测试我们的配置
 * Spring 整合junit的配置
 *      1.导入spring整合junit的jar（坐标）
 *      2.使用junit提供的一个注解把原来的main方法替换了，替换成spring提供的
 *          @Runwith
 *      3.告知spring的运行器，spring和ioc创建是基于xml还是注解的，并且说明位置
 *          @ContextConfiguration
 *              locations：指定xml文件的位置,加上classpath关键字，表示在类路径下
 *              classes： 指定注解类所在的位置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService accountService = null;

    @Test
    public void testFindAllAccount() {
        //3.执行方法
        List<Account> accounts = accountService.findAllAccount();
        for (Account account:accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindAccountById() {
        //1.获取容器
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.得到业务曾对象
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        //3.执行方法
        Account account = accountService.findAccountById(1);
        System.out.println("testFindAccountById:"+account);
    }

    @Test
    public void testSaveAccount() {
        Account account = new Account();
        account.setName("Tgst");
        account.setMoney(13200f);
        //1.获取容器
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.得到业务曾对象
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        //3.执行方法
        accountService.saveAccount(account);
    }

    @Test
    public void testUpdateAccount() {
        //1.获取容器
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
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
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.得到业务曾对象
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        //3.执行方法
        accountService.deleteAccount(4);
    }
}
