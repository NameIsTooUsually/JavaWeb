package com.chenhao.test;

import com.chenhao.mapper.BrandMapper;
import com.chenhao.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrandTest {
    SqlSession sqlSession;
    BrandMapper brandMapper;

    @Before
    public void before() throws IOException {
        String resource = "mybatis-config";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession(true);
        brandMapper = sqlSession.getMapper(BrandMapper.class);
    }

    @After
    public void after() {
        sqlSession.close();
    }

    @Test
    public void byCondition() {
        Integer status = 1;
        String brandName = "华为";
        String companyName = "华为";
        //转换字符串
        brandName = '%' + brandName + '%';
        companyName = '%' + companyName + '%';

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        //创建map
        HashMap map = new HashMap();
        map.put("status",null);
        map.put("brandName",null);
        map.put("companyName",null);
        //创建数组
        Integer[] its = {1,2};

        //List<Brand> brands = brandMapper.findByCondition(status, brandName, companyName);
        //List<Brand> brands = brandMapper.findByCondition(its);
        List<Brand> brands = brandMapper.findByCondition(map);
        for (Brand brand1 : brands) {
            System.out.println(brand1);
        }
    }

    @Test
    public void insert(){
        Integer status = 1;
        String brandName = "红米手机";
        String companyName = "红米";
        Integer ordered = 100;
        String description = "年轻人上的第一个当";
        Brand brand = new Brand();
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setStatus(status);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        int insert = brandMapper.insert(brand);
        System.out.println(insert);
        sqlSession.commit();
    }
//基本更新
    @Test
    public void update(){
        Integer status = 1;
        String brandName = "红米手机";
        String companyName = "红米";
        Integer ordered = 10;
        String description = "年轻人上的第一个洋当";
        Brand brand = new Brand();
        brand.setId(6);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        //brand.setOrdered(ordered);
        //brand.setDescription(description);
        //brand.setStatus(status);
        int update = brandMapper.update(brand);
        System.out.println(update);

    }
    @Test
    public void deleteById(){
        Integer id = 7;
        int i = brandMapper.deleteById(id);
    }
}
