package com.lx.springboot_04.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo01Index
{
    @RequestMapping("/hello")
    public  String getMsg(){
        return "hello properties";
    }
}
