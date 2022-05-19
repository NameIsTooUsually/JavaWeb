package com.chenhao.service.impl;

import com.chenhao.mapper.BrandMapper;
import com.chenhao.pojo.Brand;
import com.chenhao.service.BrandService;
import com.chenhao.utils.SqlSessionFactoryDemo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryDemo.getSqlSessionFactory();
    public List<Brand> selectAll() {
        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取映射对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用方法
        List<Brand> brands = mapper.selectAll();

        //释放资源
        sqlSession.close();

        return brands;

    }

    public Brand selectById(int id) {
        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取映射对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用方法
        Brand brand = mapper.selectById(id);

        //释放资源
        sqlSession.close();

        return brand;
    }

    public void add(Brand brand) {
        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取映射对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用方法
        mapper.add(brand);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }
}
