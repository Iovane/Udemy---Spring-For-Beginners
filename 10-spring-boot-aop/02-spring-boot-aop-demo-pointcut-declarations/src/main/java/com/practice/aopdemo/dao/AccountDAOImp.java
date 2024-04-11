package com.practice.aopdemo.dao;

import com.practice.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImp implements AccountDAO {

    private String name;

    private String serviceCode;

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        // for academic purpose simulate an exception
        if (tripWire){
            throw new RuntimeException("u r doomed GOONER!!!");
        }

        List<Account> myAccounts = new ArrayList<>();

        // create sample accounts
        Account temp1 = new Account("Anastasia", "Mshieri");
        Account temp2 = new Account("Ketevani", "Gachxikinebuli");
        Account temp3 = new Account("Tekla", "Depresiashi");

        // add them to our account list
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }

    @Override
    public void addAccount(Account account, boolean vipFlag) {

        System.out.println(getClass().getSimpleName() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass().getSimpleName() + ": doWork()");

        return false;
    }

    public String getName() {
        System.out.println(getClass().getSimpleName() + ": getName(");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass().getSimpleName() + ": setName(");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass().getSimpleName() + ": getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass().getSimpleName() + ": setServiceCode(");
        this.serviceCode = serviceCode;
    }
}
