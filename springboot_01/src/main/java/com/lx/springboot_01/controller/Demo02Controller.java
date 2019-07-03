package com.lx.springboot_01.controller;

import com.lx.springboot_01.bean.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Demo02Controller {

    private Map<String,Object> map = new HashMap<>();
    @GetMapping("/get/{id}")
    public Object getUser(@PathVariable("id")int id){

        map.clear();
        map.put("id",id);
        return map;

    }

    @PostMapping("/post")
    public Object post(User user){

        map.clear();
        map.put("user",user);
        return map;

    }

    @PutMapping("/put")
    public Object put(@RequestParam("id")int id){

        map.clear();
        map.put("id",id);
        return map;
    }

    @DeleteMapping("/del/{id}")
    public Object del(@PathVariable("id")int id){

        map.clear();
        map.put("id",id);
        return map;

    }

}
