package com.srx.test;

import com.srx.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountServiceTest {

    public static void main(String[] args) {
        //获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //获取对象
        IAccountService as = applicationContext.getBean("accountService",IAccountService.class);
        //执行方法
        as.transfer("aaa","bbb",100f);
    }

}
