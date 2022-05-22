package com.heima.service;

import com.heima.pojo.CheckItem;
import com.heima.pojo.PageBeanResult;
import com.heima.pojo.User;


public interface UserService {
    //登录
    User login(String username, String password);

    //分页查询检查项
    PageBeanResult selectByPage(int begin, int pageSize);

    //通过id进行查询
    CheckItem findById(int id);

    //增加
    void insertByOBJ(CheckItem checkItem);

    //通过id进行删除
    void deleteById(int id);
}
