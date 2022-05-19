package com.chenhao.mapper;

import com.chenhao.pojo.Brand;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {
    //显示所有
    List<Brand> selectAll();

    //根据用户名进行查询
    Brand selectById(int id);

    //添加商品
    void add(Brand brand);

}
