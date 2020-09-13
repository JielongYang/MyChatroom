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
    public User getUserByUsername(String username) {
        return this.userDao.getUserByUsername(username);
    }

    @Override
    public User getUSerByUsernameAndPassword(String username, String password) {
        return this.userDao.getUSerByUsernameAndPassword(username,password);
    }

    @Override
    public int insert(User user) {
        userDao.insert(user);
        return 0;
    }

    @Override
    public int upload(String path, String username) {
        return userDao.upload(path, username);
    }


}
