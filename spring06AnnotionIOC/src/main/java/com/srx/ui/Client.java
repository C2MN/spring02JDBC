package com.srx.ui;

import com.srx.dao.IAccountDao;
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
        IAccountService accountService = (IAccountService) ac.getBean("accountServiceImpl");
        IAccountDao accountDao = ac.getBean("accountDaoImpl",IAccountDao.class);
        IAccountDao accountDao1 = ac.getBean("accountDaoImpl1",IAccountDao.class);

        System.out.println(accountService);
        System.out.println(accountDao);
        System.out.println(accountDao1);
        accountService.saveAccount();
        accountDao.saveAccount();
        accountDao1.saveAccount();

    }
}
