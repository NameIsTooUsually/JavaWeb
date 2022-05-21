package com.chenhao.mapper;

import com.chenhao.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {

    //查询所有
    @Select("select * from tb_brand")
    @ResultMap("BrandMap")
    List<Brand> selectAll();

    //添加
    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void addBrand(Brand brand);


    void deleteByIds(@Param("ids") int...ids);

    //分页查询
    @Select("select * from tb_brand limit #{begin},#{size}")
    List<Brand> selectByPage(@Param("begin") int begin,@Param("size")int size);


    //总数查询
    @Select("select count(*) from tb_brand")
    int SelectTotal();

    //分页和条件查询条件查询
    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size")int size,@Param("brand")Brand brand);
    int selectTotalByPageAndCondition(Brand brand);
}
