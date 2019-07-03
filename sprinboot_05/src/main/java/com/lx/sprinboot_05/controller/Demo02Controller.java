package com.lx.sprinboot_05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Demo02Controller {

    @RequestMapping("/demo01")
    public String getDemo01(HttpServletRequest req){

        //通过 作用域 来 把 数据 发送到 html界面
        req.setAttribute("req","request 作用域");
        req.getSession().setAttribute("key","session 作用域");
        req.getServletContext().setAttribute("app","application 作用域");

        return "index02";

    }

    @RequestMapping("/demo02")
    public String getDemo02(@RequestParam("id")String id,@RequestParam("name")String name){

        System.out.println("id - > " + id );
        System.out.println("name - > " + name );
        return "index02";

    }

    @RequestMapping("/demo03/{id}/{name}")
    public String getDemo03(@PathVariable("id") String id,@PathVariable("name")String name){
        System.out.println("id - > " + id );
        System.out.println("name - > " + name );
        return "index02";
    }

}
