package com.chenhao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean<T> {
    //总记录数
    private int totalCount;

    //每页的数据
    private List<T> row;
}
