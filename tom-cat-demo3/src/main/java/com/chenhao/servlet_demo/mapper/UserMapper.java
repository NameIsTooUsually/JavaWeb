package com.chenhao.servlet_demo.mapper;

import com.chenhao.servlet_demo.polo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    User validateUser(@Param("username") String username, @Param("password") String password);

    @Update("insert into tb_user (username,password) values (#{username},#{password})")
    int updateUser(User user);

    @Select("select * from tb_user where username = #{username}")
    User selectByUserName(@Param("username") String username);
}
