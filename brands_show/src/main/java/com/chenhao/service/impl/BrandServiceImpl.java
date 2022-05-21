package com.chenhao.service.impl;

import com.chenhao.mapper.BrandMapper;
import com.chenhao.pojo.Brand;
import com.chenhao.pojo.PageBean;
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

    public void deleteByIds(int... ids) {
        //创建sqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取Mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用方法
        mapper.deleteByIds(ids);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();

    }

    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        //创建sqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取Mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //查询页
        //开始编号
        int begin = (currentPage - 1) * pageSize;
        // 调用查询页方法
        List<Brand> brands = mapper.selectByPage(begin, pageSize);

        //查询总数
        int total = mapper.SelectTotal();

        //释放资源
        sqlSession.close();

        //创建PageBean
        PageBean<Brand> pageBean = new PageBean<Brand>();
        pageBean.setRow(brands);
        pageBean.setTotalCount(total);

        return pageBean;
    }

    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        //创建sqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获取Mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //查询页
        //开始编号
        int begin = (currentPage - 1) * pageSize;
        //条件进行设置，设置成模糊查询的格式
        String brandName = brand.getBrandName();
        if(brandName!=null&&brandName.length()>0){
            brand.setBrandName("%"+brandName+"%");
        }
        String companyName = brand.getCompanyName();
        if(companyName!=null&&companyName.length()>0){
            brand.setCompanyName("%"+companyName+"%");
        }


        // 调用方法
        List<Brand> brands = mapper.selectByPageAndCondition(begin, pageSize,brand);

        //根据条件查询查询总数
        int total = mapper.selectTotalByPageAndCondition(brand);

        //释放资源
        sqlSession.close();

        //创建PageBean
        PageBean<Brand> pageBean = new PageBean<Brand>();
        pageBean.setRow(brands);
        pageBean.setTotalCount(total);

        return pageBean;

    }
}
