package com.chenhao.pojo;

import lombok.Data;

@Data
public class Brand {
    private Integer id;
    private String brandName;
    private String companyName;
    private Integer ordered;
    private String description;
    private Integer status;
}
