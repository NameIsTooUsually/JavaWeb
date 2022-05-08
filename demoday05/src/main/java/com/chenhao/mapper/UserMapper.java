package com.chenhao.mapper;

import com.chenhao.pojo.User;

import java.util.List;

public interface UserMapper {
    //获取所有
    List<User> findAll();
    //获取一个
    User findOne(Integer id);
    //固定个数的多条件查询
}
