package com.lx.springboot_01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //  @Controller(控制器)  + @ResponseBody (回写的数据是 json (str返回的是str 对象返回的是json))
public class Demo01Controller {

    @RequestMapping("/demo01")
    public String demo01(){

        return "hello  springboot ";
    }

}
