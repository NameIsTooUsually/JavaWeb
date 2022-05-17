package com.chenhao.service;

import com.chenhao.pojo.User;

public interface UserService {
    //根据用户名和密码进行查询
    User login(String username, String password);
    //根据用户名进行查询
    User selectByUsername(String username);
    //添加用户
    boolean register(User user);
}
