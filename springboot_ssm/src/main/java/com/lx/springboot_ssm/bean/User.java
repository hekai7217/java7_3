package com.lx.springboot_ssm.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // set / get 注解
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    private String username;
    private int sex;
    private String address;

}
