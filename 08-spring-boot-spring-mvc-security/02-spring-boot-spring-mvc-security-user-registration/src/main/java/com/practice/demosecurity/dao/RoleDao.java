package com.practice.demosecurity.dao;

import com.practice.demosecurity.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
