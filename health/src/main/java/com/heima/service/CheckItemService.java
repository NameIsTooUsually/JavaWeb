package com.heima.service;

import com.heima.pojo.CheckItem;
import com.heima.pojo.QueryDTO;
import com.heima.pojo.PageBeanResult;

import java.util.List;


public interface CheckItemService {

    //分页查询
    PageBeanResult selectByPage(QueryDTO queryDTO);
    //通过id进行查询
    CheckItem findById(int id);

    //增加
    boolean insertByOBJ(CheckItem checkItem);

    //通过id进行删除
    boolean deleteById(int id);

    //修改
    int updateByOBJ(CheckItem checkItem);

    //查询所有
    List<CheckItem> findAll();
}
