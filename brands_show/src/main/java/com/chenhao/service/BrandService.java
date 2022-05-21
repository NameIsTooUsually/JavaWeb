package com.chenhao.service;

import com.chenhao.pojo.Brand;
import com.chenhao.pojo.PageBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandService {
    //查询所有
    List<Brand> selectAll();

    //添加品牌
    void addBrand(Brand brand);

    //根据条件删除
    void deleteByIds(int...ids);

   //查询指定页
    PageBean<Brand> selectByPage(int currentPage,int pageSize);

    //根据条件和页面查询
    PageBean<Brand> selectByPageAndCondition(int currentPage,int pageSize,Brand brand);


}
