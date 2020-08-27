package com.yang.service;
import com.yang.dao.UserDao;
import com.yang.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer id) {
        return this.userDao.getUserById(id);
    }

    @Override
    public User getUSerByUsernameAndPassword(String username, String password) {
        return this.userDao.getUSerByUsernameAndPassword(username,password);
    }
}
