package com.chenhao.mapper;

import com.chenhao.pojo.Store;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StoreMapper {

    //向表中添加如下数据
    int insert(Store store);
    //通过id删除
    int deleteByid(Integer id);
    //查询 表中所有的数据，并封装到集合中
    List<Store> findAll();
    //查询 `id=2` 的数据，并将数据封装到实体类对象中
    Store findByid(Integer id);
    //将 `id=1` 的数据 `area` 字段值修改为 `北京市昌平区`， `phone` 字段值修改为 `13629224217`
    int setById(Store store);
    //批量删除
    void deleteByIds(@Param("ids") List ids);
    //
    List<Store> findCondition(Map<String,Object> condition);
    //添加一条记录，并返回生成的主键
    int insertReturnPK(Store store);
}
