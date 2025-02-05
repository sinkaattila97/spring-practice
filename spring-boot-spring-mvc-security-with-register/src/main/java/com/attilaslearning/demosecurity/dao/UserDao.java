package com.attilaslearning.demosecurity.dao;

import com.attilaslearning.demosecurity.entity.User;

public interface UserDao {

    User findByUserName(String userName);

    void save(User theUser);
}
