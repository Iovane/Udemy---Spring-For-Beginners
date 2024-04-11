package com.practice.demosecurity.service;

import com.practice.demosecurity.entity.User;
import com.practice.demosecurity.user.WebUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	void save(WebUser webUser);

}
