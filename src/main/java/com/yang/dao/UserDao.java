package com.yang.dao;

import com.yang.entity.User;
import org.apache.ibatis.annotations.Param;


public interface UserDao {

    User getUserById(Integer id);

    User getUSerByUsernameAndPassword(@Param("username")String username, @Param("password")String password);



}
