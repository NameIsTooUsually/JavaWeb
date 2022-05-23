package com.heima.mapper;

import com.heima.pojo.CheckItem;
import com.heima.pojo.QueryDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CheckItemMapper {
    //分页查询
    List<CheckItem> selectByPage(QueryDTO queryDTO);

    //查询总数
    int selectTotal(QueryDTO queryDTO);


    //通过ID进行查询
    @Select("select * from t_checkitem where id = #{id}")
    CheckItem findById(int id);

    //新增
    int insertByOBJ(CheckItem checkItem);

    //通过id删除
    @Delete("delete from t_checkitem where id = #{id}")
    int deleteById(int id);

    //修改
    int updateByOBJ(CheckItem checkItem);

    //查询所有检查项
    @Select("select * from t_checkitem")
    List<CheckItem> findAll();
}
