package com.srx.service.impl;

import com.srx.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    @Override
    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了");
    }
}
