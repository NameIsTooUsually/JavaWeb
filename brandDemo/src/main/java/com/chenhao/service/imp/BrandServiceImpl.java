package com.chenhao.service.imp;

import com.chenhao.Utils.SqlSessionFactoryDemo;
import com.chenhao.mapper.BrandMapper;
import com.chenhao.pojo.Brand;
import com.chenhao.service.BrandServise;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandServise {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryDemo.getSqlSessionFactory();

    //查询所有
    public List<Brand> selectAll() {
      //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mapper对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //调用方法
        List<Brand> brands = brandMapper.selectAll();
        //关闭资源
        sqlSession.close();
        return brands;
    }
    //增加
    public void add(Brand brand) {
        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mapper对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //调用方法
        brandMapper.add(brand);
        //提交事务
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }

    @Override
    public Brand selectById(int id) {
        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mapper对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //调用方法
        Brand brand = brandMapper.selectById(id);
        //将结果返回
        return brand;
    }

    @Override
    public void update(Brand brand) {
        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mapper对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //调用方法
        brandMapper.update(brand);
        //提交事务
        sqlSession.commit();
        //关闭资源
        sqlSession.close();

    }

    @Override
    public void deleteById(int id) {
        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mapper对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //调用方法
        brandMapper.deleteById(id);
        //提交事务
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }
}
