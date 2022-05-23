package com.heima.mapper;

import com.heima.pojo.CheckGroup;
import com.heima.pojo.QueryDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckGroupMapper {
    //分页查询,检查组分页查询
    //分页查询
    List<CheckGroup> selectByPageAndCondition(QueryDTO queryDTO);

    //查询总数
    Integer selectTotal(QueryDTO queryDTO);

    //向表中添加数据，并获取返回的主键
    Integer insertByOBJ(CheckGroup checkGroup);

    //
    @Insert("insert into t_checkgroup_checkitem values(#{primaryKey},#{id})")
    int insertCheckGroup(@Param("primaryKey") int primaryKey, @Param("id") int id);
}
