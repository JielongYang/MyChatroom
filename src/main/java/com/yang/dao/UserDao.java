package com.yang.dao;

import com.yang.entity.User;
import org.apache.ibatis.annotations.Param;


public interface UserDao {

    User getUserByUsername(String username);

    User getUSerByUsernameAndPassword(@Param("username")String username, @Param("password")String password);

    int insert(User user);

    int upload(@Param("head") String head, @Param("username") String username);
}
