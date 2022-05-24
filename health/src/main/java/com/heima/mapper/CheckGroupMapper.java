package com.heima.mapper;

import com.heima.pojo.CheckGroup;
import com.heima.pojo.QueryDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CheckGroupMapper {
    //分页查询,检查组分页查询
    //分页查询
    List<CheckGroup> selectByPageAndCondition(QueryDTO queryDTO);

    //查询总数
    Integer selectTotal(QueryDTO queryDTO);

    //向表中添加数据，并获取返回的主键
    Integer insertByOBJ(CheckGroup checkGroup);

    //向表t_checkgroup_checkitem添加对应的条目
    @Insert("insert into t_checkgroup_checkitem values(#{primaryKey},#{id})")
    int insertCheckGroup(@Param("primaryKey") int primaryKey, @Param("id") int id);

    @Select("select * from t_checkgroup where id = #{id}")
    CheckGroup findById(int id);

    List<CheckGroup> findCheckItemById(int id);


    //根据checkGroupID 查询 t_checkgroup_checkitem 中数据
    int[] findByCheckGroupID(int id);

    //修改checkGroup数据
    int updateByCheckGroupOBj(CheckGroup checkGroup);
}
