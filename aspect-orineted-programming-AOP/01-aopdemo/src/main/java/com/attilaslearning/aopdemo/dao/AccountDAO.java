package com.attilaslearning.aopdemo.dao;

import com.attilaslearning.aopdemo.Account;

public interface AccountDAO {

    void addAccount();
    void addAccount(Account account);
    void addAccount(Account account, boolean vipFlag);

    boolean doWork();
}
