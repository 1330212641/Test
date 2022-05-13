package com.service;

import com.pojo.User;
import org.apache.catalina.Manager;

import java.util.List;

public interface UserService {
    public User login(User u);
    public List<User> showUser();
    public int UpdateManager(Integer uid,Integer manager);
    public Integer deleteuser(List<Integer> uids);
    public Integer deleteuser1(Integer uids);
    public int adduser(User user);
}
