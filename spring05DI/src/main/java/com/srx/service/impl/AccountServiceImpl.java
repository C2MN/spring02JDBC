package com.srx.service.impl;

import com.srx.service.IAccountService;

import java.util.Date;

public class AccountServiceImpl implements IAccountService {

    //如果经常变化的数据并不适用于注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name,Integer age,Date birthday){
        this.name = name;
        this.age = age;
        this.birthday= birthday;
    }

    @Override
    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了------"+name+"********"+age+"*********"+birthday);
    }
}
