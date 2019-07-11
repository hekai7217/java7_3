package com.lx.springboot_stu_consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.lx.bean.Student;
import com.lx.service.StuService;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
public class StuController  {

    // 和 jdbc 模板一样
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Reference(timeout = 3000,retries = 3)
    private StuService stuService;

    @RequestMapping("/stus")
    public List<Student> queryStu(){


        List<Student> stus = null;

        //从 redis中拿到的是str json
        String stus_json = redisTemplate.opsForValue().get("stus");

        if (stus_json != null && stus_json != ""){
            //转成对象
            stus = JSON.parseArray(stus_json, Student.class);
            System.out.println("从内存中reids 中的数据=======" + stus_json);
        }
        if (stus == null){

            System.out.println("从db 中获取数据 ...");

            stus = stuService.queryStus();

            //从数据库总获取数据后 存到 Redis中

            // redisTemplate.opsForValue() java 操作字符串对象

            redisTemplate.opsForValue().set("stus",JSON.toJSONString(stus));
        }
        return stus;
    }

    @RequestMapping("/stu/{id}")
    public int delStu(@PathVariable("id") int id){
        int del = stuService.delStu(id);
        return del;
    }
}
