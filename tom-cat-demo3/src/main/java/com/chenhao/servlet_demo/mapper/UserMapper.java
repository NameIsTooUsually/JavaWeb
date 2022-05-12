package com.chenhao.servlet_demo.mapper;

import com.chenhao.servlet_demo.polo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User validateUser(@Param("username") String username, @Param("password") String password);
}
