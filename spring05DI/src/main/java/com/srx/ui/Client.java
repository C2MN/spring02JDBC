package com.srx.ui;

import com.srx.service.IAccountService;
import com.srx.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    /**
     * 获取spring的ioc核心容器，并根据id获取对象
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        IAccountService accountService2 = (IAccountService) ac.getBean("accountService2");

        System.out.println(accountService);
        accountService.saveAccount();
        System.out.println(accountService2);
        accountService2.saveAccount();
    }

}
