package com.practice.aopdemo.dao;

import com.practice.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account account, boolean vipFlag);

    boolean doWork();
}
