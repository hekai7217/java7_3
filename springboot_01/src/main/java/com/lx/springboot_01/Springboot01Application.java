package com.lx.springboot_01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //  加载了 多自动配置 + 自动扫描 注解 (自动扫描注解 + 加载applicationContext.xml + springmvc.xml)
public class Springboot01Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot01Application.class, args);
    }

}
