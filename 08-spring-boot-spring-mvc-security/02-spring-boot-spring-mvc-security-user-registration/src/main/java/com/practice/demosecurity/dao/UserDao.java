package com.practice.demosecurity.dao;

import com.practice.demosecurity.entity.User;

public interface UserDao {

    User findByUserName(String userName);

    void save(User theUser);
}
