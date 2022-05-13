package com.service;

import com.mapper.UserMapper;
import com.pojo.User;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;
    @Override
    public User login(User u) {
        return userMapper.login(u);
    }

    @Override
    public List<User> showUser() {
        return userMapper.showUser();
    }

    @Override
    public int UpdateManager(Integer uid,Integer manager) {
        return userMapper.UpdateManager(uid,manager);
    }

    @Override
    public Integer deleteuser(List<Integer> uids) {
        return userMapper.deleteuser(uids);
    }

    @Override
    public Integer deleteuser1(Integer uid) {
        return userMapper.deleteuser1(uid);
    }

    @Override
    public int adduser(User user) {
        return userMapper.addUser(user);
    }
}
