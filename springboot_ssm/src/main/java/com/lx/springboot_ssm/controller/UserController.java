package com.lx.springboot_ssm.controller;

import com.lx.springboot_ssm.bean.User;
import com.lx.springboot_ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/queryUser/{id}")
    public User queryUserById(@PathVariable("id")int id){
        // 返回一个对象 ctrl + alt + u
        User u = userService.queryUserById(id);
        System.out.println("u :" + u);
        return u;
    }

    @RequestMapping("/queryAll")
    public List<User> queryAll(){

        List<User> list = userService.queryAll();
        System.out.println(list);

        return list;
    }
}
