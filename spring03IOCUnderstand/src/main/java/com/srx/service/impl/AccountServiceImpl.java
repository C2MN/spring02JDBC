package com.srx.service.impl;

import com.srx.dao.IAccountDao;
import com.srx.dao.impl.AccountDaoImpl;
import com.srx.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    IAccountDao accountDao = new AccountDaoImpl();

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
