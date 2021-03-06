package com.srx.test;

import com.srx.service.IAccountService;
import com.srx.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试AOP的配置
 */
public class AopTest {
    public static void main(String[] args) {
        //1.获取容情
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountService as = applicationContext.getBean("accountService",IAccountService.class);
        //3.执行方法
        as.saveAccount();
    }
}
