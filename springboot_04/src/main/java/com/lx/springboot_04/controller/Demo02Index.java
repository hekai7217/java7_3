package com.lx.springboot_04.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo02Index {

    // 使用el表达式 可以 获取 yaml 中配置的属性
    @Value("${info.env}")
    private String env;

    /**
     * 多环境的配置
     * @return
     */
    @RequestMapping("/test")
    public String getMsg(){
        return "当前的环境是:" + env;
    }
}
