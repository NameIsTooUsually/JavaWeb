package com.heima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckGroup {
    private Integer id;
    private String code;
    private String name;
    private String helpCode;
    private Character sex;
    private String remark;
    private String attention;
    private String checkItems;
}
