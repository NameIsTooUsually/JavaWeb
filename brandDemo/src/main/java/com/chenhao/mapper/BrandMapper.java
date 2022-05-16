package com.chenhao.mapper;

import com.chenhao.pojo.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BrandMapper {
    //查询所有
    @Select("select * from tb_brand")
    List<Brand> selectAll();

    //增加
    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);

    //回显数据
    @Select("select * from tb_brand where id = #{id}")
    Brand selectById(int id);

    void update(Brand brand);

    @Delete("delete from tb_brand where id = #{id}")
    void deleteById(int id);
}
