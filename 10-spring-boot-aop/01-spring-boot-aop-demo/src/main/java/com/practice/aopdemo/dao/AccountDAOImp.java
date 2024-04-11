package com.practice.aopdemo.dao;

import com.practice.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImp implements AccountDAO {

    @Override
    public void addAccount(Account account, boolean vipFlag) {

        System.out.println(getClass().getSimpleName() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass().getSimpleName() + ": doWork()");

        return false;
    }
}
