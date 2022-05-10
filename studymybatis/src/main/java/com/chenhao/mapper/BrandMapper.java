package com.chenhao.mapper;

import com.chenhao.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {

    //查询所有数据
    List<Brand> findAll();

    //查询详情
    Brand findOne(Integer id);

    //固定个数的多条件查询
    List<Brand> findByFixConditions(@Param("brandName") String brandName, @Param("companyName") String companyName, @Param("status") Integer status);

    //不固定个的条件查询
    List<Brand> findByConditions(Brand brand);

    //不确定的单个条件查询
    List<Brand> findByCondition(Brand brand);

    //基本添加
    int addOne(Brand brand);

    //添加并返回主键
    int  addOneReturnPK(Brand brand);

    //修改内容
    int updateByOBJ(Brand brand);

    //删除一行数据
    int deleteByid(Integer id);

    //删除多行数据
    int deleteByIds(@Param("ids") int[] ids);


    //注解实现
    @Select(value = "select * from tb_brand where id = #{id}")
    Brand findByIdAnnotation(Integer id);
}
