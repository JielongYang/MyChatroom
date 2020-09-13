package com.yang.service;

import com.yang.entity.User;



public interface UserService {

    public User getUserByUsername(String username);

    public User getUSerByUsernameAndPassword(String username,String password);

    public int insert(User user);

    public int upload(String path, String username);

}
