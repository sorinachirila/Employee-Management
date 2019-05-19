package com.sda.service;

import com.sda.dao.UserDao;
import com.sda.model.User;

public class UserService {

    private UserDao userDao = new UserDao();

    public User login(String username, String password){
        return userDao.findByUsernameAndPassword(username, password);
    }
}
