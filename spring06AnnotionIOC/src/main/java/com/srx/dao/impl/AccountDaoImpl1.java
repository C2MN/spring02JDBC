package com.srx.dao.impl;

import com.srx.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDaoImpl1")
public class AccountDaoImpl1 implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("持久层保存账户！！！");
        System.out.println("dao中的saveAccount方法执行了！！！++++++++++++++++++++++++");
    }
}
