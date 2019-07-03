package com.lx.springboot_02.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/test")
    public String getStr(){
        return  "hello web ccccc";
    }
}
