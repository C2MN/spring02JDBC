package com.srx.dao.impl;

import com.srx.dao.IAccountDao;

public class AccountDaoImpl implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存成功！");
    }
}
