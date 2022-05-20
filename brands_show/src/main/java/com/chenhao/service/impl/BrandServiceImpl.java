package com.chenhao.service.impl;

import com.chenhao.mapper.BrandMapper;
import com.chenhao.pojo.Brand;
import com.chenhao.service.BrandService;
import com.chenhao.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    private SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Brand> selectAll() {
        //创建sqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取Mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用方法
        List<Brand> brands = mapper.selectAll();

        //释放资源
        sqlSession.close();

        //返回参数
        return brands;
    }

    public void addBrand(Brand brand) {
        //创建sqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取Mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用方法
        mapper.addBrand(brand);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }
}
