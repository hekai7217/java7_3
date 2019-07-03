package com.lx.springboot_03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Result;

//@ControllerAdvice  // springboot 中使用  ControllerAdvice + ExceptionHandler 可以统一处理 异常
@RestController
public class Index01Controller {

    @RequestMapping("/demo02")
    public String demo01(){

        int i = 10 /0;
        return "hello";

    }

    @RequestMapping("/demo03")
    public String demo02(){

        String str = null;
        int len = str.length();

        return "hello";

    }

//    @ExceptionHandler(value =  ArithmeticException.class)
    public String jsonErrorHandler(HttpServletRequest req, Exception e){

        System.out.println("报错了 执行我的方法...");

        return "数学异常";
    }


//    @ExceptionHandler(value =  NullPointerException.class)
    public String testNullException(HttpServletRequest req, Exception e){
        return "空指针异常" + e.getMessage();
    }
}
