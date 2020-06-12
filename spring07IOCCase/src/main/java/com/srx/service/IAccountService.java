package com.srx.service;

import com.srx.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */
public interface IAccountService {
    /**
     * 查询所有账户信息
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 根据id查询一个账户信息
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存账户信息
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 跟新账户信息
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除账户信息
     * @param accountId
     */
    void deleteAccount(Integer accountId);
}
