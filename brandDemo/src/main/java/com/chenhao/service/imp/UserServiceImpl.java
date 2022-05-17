package com.chenhao.service.imp;

import com.chenhao.Utils.SqlSessionFactoryDemo;
import com.chenhao.mapper.UserMapper;
import com.chenhao.pojo.User;
import com.chenhao.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserServiceImpl implements UserService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryDemo.getSqlSessionFactory();

    @Override
    public User login(String username, String password) {
        //查询数据
        //获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取映射对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用方法
        User user = userMapper.select(username, password);

        //释放资源
        sqlSession.close();

        //返回参数
        return user;
    }

    @Override
    public User selectByUsername(String username) {
        //获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取映射对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用方法判断
        User user = userMapper.selectByUsername(username);
        return user;
    }

    @Override
    public boolean register(User user) {
        //获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取映射对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用方法判断该名字是否存在
        User user1 = userMapper.selectByUsername(user.getUsername());
        if(null==user1){
            //用户名不存在可以注册
            userMapper.add(user);
            //提交事务
            sqlSession.commit();
        }
        //释放资源
        sqlSession.close();


        return null==user1;
    }
}
