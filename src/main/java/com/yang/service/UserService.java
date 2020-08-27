package com.yang.service;

import com.yang.entity.User;



public interface UserService {

    public User getUserById(Integer id);

    public User getUSerByUsernameAndPassword(String username,String password);

}
