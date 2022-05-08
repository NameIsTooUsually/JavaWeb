package com.chenhao.mapper;

import com.chenhao.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    //固定多条件查询
    //List<Brand> findByCondition(@Param("status") Integer status, @Param("brandName") String brandName,@Param("companyName") String companyName);
    //List<Brand> findByCondition(Brand brand);
    List<Brand> findByCondition(Map map);
    //List<Brand> findByCondition(@Param("its") Integer[] its);
    int insert(Brand brand);
    int update(Brand brand);
    int deleteById(Integer id);
    int deleteMulti(Integer[] ids);

}
