package com.heima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 返回值，由前后端协定
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    private boolean flag;

    private String message;

    private T data;

}
