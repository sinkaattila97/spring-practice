package com.attilaslearning.demosecurity.service;

import com.attilaslearning.demosecurity.entity.User;
import com.attilaslearning.demosecurity.user.WebUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	void save(WebUser webUser);

}
