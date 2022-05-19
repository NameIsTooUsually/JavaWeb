package com.chenhao.service;

import com.chenhao.pojo.Brand;

import java.util.List;

public interface BrandService {
    //查询所有
    List<Brand> selectAll();

    //根据用户名进行查询
    Brand selectById(int id);

    //添加商品
    void add(Brand brand);
}
