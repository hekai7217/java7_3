package com.lx.sprinboot_05.controller;

import com.lx.sprinboot_05.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class Demo01Controller {

    @RequestMapping("/hello")
    public String demo01(ModelMap map) {

        map.put("msg", "thymeleaf 入门程序");
        return "index";
    }


    @RequestMapping("/index01")
    public String index01(ModelMap map) {

        map.put("msg", "hello java");
//        map.put("key", "");
        map.put("name", "java");
        map.put("date", new Date());

        User user = new User();
        user.setPassword("111");
        user.setUsername("aaa");
        map.put("user", user);

        List<User> list = new ArrayList<User>();

        list.add(new User("乔峰","aa"));
        list.add(new User("虚竹","bb"));
        list.add(new User("甘宝宝","cc"));
        list.add(new User("秦红棉","dd"));

        map.put("list",list);

        Map<String,User> hashmap = new HashMap<>();

        hashmap.put("aa",new User("张无忌","明教"));
        hashmap.put("bb",new User("杨晓","明教"));
        hashmap.put("cc",new User("胡青牛","明教"));

        map.put("map",hashmap);

        return "index01";

    }

    @RequestMapping("/save")
    public String getName(@RequestParam("name")String name){

        System.out.println("name--->" + name);
        return "index01";
    }
}
