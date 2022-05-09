package com.chenhao.test;

import com.chenhao.mapper.UserMapper;
import com.chenhao.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {
    UserMapper mapper;
    SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        String resource = "mybatis-config";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void after(){
        sqlSession.close();
    }
//获取所有
    @Test
    public void findAll() {
        List<User> users = mapper.findAll();
        System.out.println(users);
    }
    //根据id 获取一行
    @Test
    public void findOne(){
        Integer id = 2;
        User user = mapper.findOne(id);
        System.out.println(user);
    }



}
