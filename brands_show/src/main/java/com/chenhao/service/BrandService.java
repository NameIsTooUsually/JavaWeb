package com.chenhao.service;

import com.chenhao.pojo.Brand;

import java.util.List;

public interface BrandService {
    //查询所有
    List<Brand> selectAll();

    //添加品牌
    void addBrand(Brand brand);

}
