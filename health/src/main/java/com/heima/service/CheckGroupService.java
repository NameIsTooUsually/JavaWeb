package com.heima.service;

import com.heima.pojo.CheckGroup;
import com.heima.pojo.PageBean;
import com.heima.pojo.QueryDTO;

import java.util.List;

public interface CheckGroupService {
    //通过页面和条件进行查询
    PageBean<CheckGroup> selectByPageAndCondition(QueryDTO queryDTO);

    //添加检查组
    boolean addGroup(CheckGroup checkGroup,int[] ids);

    //根据id进行查询
    CheckGroup findById(int id);

    //通过checkGroupId找关联的checkItemID
    int[] findCheckItemById(int id);

    boolean editCheckGroup(CheckGroup checkGroup, int[] ids);
}

