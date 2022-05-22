package com.heima.service.impl;

import com.alibaba.fastjson.JSON;
import com.heima.mapper.UserMapper;
import com.heima.pojo.CheckItem;
import com.heima.pojo.PageBeanResult;
import com.heima.pojo.User;
import com.heima.service.UserService;
import com.heima.utils.MyBatisConfigUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public User login(String username,String password) {
        //获取SQLSession对象
        SqlSession sqlSession = MyBatisConfigUtils.getSqlSession();

        //获取映射对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用方法
        User user = userMapper.findByUsernameAndPassword(username,password);

        //释放资源
        sqlSession.close();

        return user;
    }

    @Override
    public PageBeanResult selectByPage(int currentPage, int pageSize) {
        //获取SQLSession对象
        SqlSession sqlSession = MyBatisConfigUtils.getSqlSession();

        //获取映射对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //计算分页起始编码
        int begin = (currentPage-1)*pageSize;
        //调用方法
        List<CheckItem> checkItems = userMapper.selectByPage(begin, pageSize);
        int total = userMapper.selectTotal();

        //创建PageBeanResult对象
        PageBeanResult pageBeanResult = new PageBeanResult();
        pageBeanResult.setTotal(total);
        pageBeanResult.setRows(JSON.toJSONString(checkItems));

        //释放资源
        sqlSession.close();

        return pageBeanResult;
    }

    @Override
    public CheckItem findById(int id) {
        //获取SQLSession对象
        SqlSession sqlSession = MyBatisConfigUtils.getSqlSession();

        //获取映射对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用方法
        CheckItem checkItem = userMapper.findById(id);
        return checkItem;
    }

    @Override
    public void insertByOBJ(CheckItem checkItem) {
        //获取SQLSession对象
        SqlSession sqlSession = MyBatisConfigUtils.getSqlSession();

        //获取映射对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用方法
        userMapper.insertByOBJ(checkItem);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();

    }

    @Override
    public void deleteById(int id) {
        //获取SQLSession对象
        SqlSession sqlSession = MyBatisConfigUtils.getSqlSession();

        //获取映射对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用方法
        userMapper.deleteById(id);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }
}
