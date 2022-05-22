package com.heima.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Integer id;

    private Date birthday;

    private String gender;

    private String username;

    private String password;

    private String remark;

    private String station;

    private String telephone;

}
