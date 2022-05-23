package com.heima.service;

import com.heima.pojo.CheckGroup;
import com.heima.pojo.PageBean;
import com.heima.pojo.QueryDTO;

public interface CheckGroupService {
    //通过页面和条件进行查询
    PageBean<CheckGroup> selectByPageAndCondition(QueryDTO queryDTO);

    //添加检查组
    boolean addGroup(CheckGroup checkGroup,int[] ids);
}
