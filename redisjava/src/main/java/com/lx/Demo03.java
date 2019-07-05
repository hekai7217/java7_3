package com.lx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.JedisPool;

public class Demo03 {

    public static void main(String[] args) throws Exception{
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        JedisPool pool = ioc.getBean("jedisPool",JedisPool.class);
        System.out.println(pool.getResource().ping());
    }
}
