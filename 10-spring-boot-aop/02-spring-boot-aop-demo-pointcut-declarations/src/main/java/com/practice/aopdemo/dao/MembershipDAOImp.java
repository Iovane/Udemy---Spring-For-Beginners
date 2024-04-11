package com.practice.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImp implements MembershipDAO {

    @Override
    public boolean addSillyMember() {

        System.out.println(getClass().getSimpleName() + ": DOING MY DB WORK: ADDING A SILLY MEMBER ACCOUNT");

        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass().getSimpleName() + ": going to sleep");
    }
}
