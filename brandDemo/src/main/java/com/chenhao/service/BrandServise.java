package com.chenhao.service;

import com.chenhao.pojo.Brand;

import java.util.List;

public interface BrandServise {
    //查询所有
    public List<Brand> selectAll();

    //增加
    public void  add(Brand brand);

    //回显
    Brand selectById(int id);

    //更新
    void update(Brand brand);

    //删除
    void deleteById(int id);
}
