package com.heima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 返回值，由前后端协定
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageBeanResult<T> {
    private int total;

    private boolean flag;

    private String message;

    private List<T> rows;

}
