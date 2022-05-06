package com.chenhao;

import com.chenhao.mapper.UserMapper;
import com.chenhao.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*
mybatis快速入门
 */
public class MybatisDemo2 {
    public static void main(String[] args) throws IOException {
        //1加载mabatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2获取队形sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3获取UserMapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        System.out.println(users);
        //释放资源
        sqlSession.close();
    }
}
