package com.attilaslearning.demosecurity.dao;

import com.attilaslearning.demosecurity.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
