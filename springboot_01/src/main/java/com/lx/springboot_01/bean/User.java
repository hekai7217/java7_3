package com.lx.springboot_01.bean;

import lombok.*;

// 使用 注解可以不用使用set 和get
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private String username;
    private String password;

    public static void main(String[] args) {

    }

}
