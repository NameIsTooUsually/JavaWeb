package com.heima.mapper;

import com.heima.pojo.QueryDTO;
import com.heima.pojo.Setmeal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SetmealMapper {
    //分页查询
    List<Setmeal> selectByPageAndCondition(QueryDTO queryDTO);

    //查询总数
    Integer selectTotal(QueryDTO queryDTO);

    //根据Setmeal对象添加一条记录
    int insertByOBJ(Setmeal setmeal);

    //根据Setmeal 主键查询t_setmeal_checkgroup中_checkgroup的id
    int[] findBySetmealID(int primaryKry);

    //向t_setmeal_checkgroup中插入记录
    int insertSetmeal(@Param("primaryKry") int primaryKry, @Param("id") int id);
}
