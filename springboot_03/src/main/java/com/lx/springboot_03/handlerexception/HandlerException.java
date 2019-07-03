package com.lx.springboot_03.handlerexception;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 把异常处理 注册到 springmvc.xml   = Configuration
@Configuration
public class HandlerException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        ModelAndView mv = new ModelAndView();
        if (ex instanceof NullPointerException){
            mv.setViewName("null");
        }
        if (ex instanceof ArithmeticException){
            mv.setViewName("math");
        }
        System.out.println("执行了这个方法 ....");
        return mv;
    }
}
