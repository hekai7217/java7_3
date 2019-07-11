package com.lx.mybatis_test01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.lx")
@SpringBootApplication
public class MybatisTest01Application {

    public static void main(String[] args) {
        SpringApplication.run(MybatisTest01Application.class, args);
    }

}
