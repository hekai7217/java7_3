package com.lx.springboot_stu_consumer.mqlistener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service  // 把监听注册到 ioc 容器中
public class MyActiveMqListenter  {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    // 注册 我们的 mq  的监听
    // destination  queue 的名字
    @JmsListener(destination = "springboot_queue")
    public void receiveQueue(String msg) {

        if(msg != null && msg.equals("del")){

            // 我收到了  数据库 数据的刷新  redis 中数据 需要清理

            redisTemplate.opsForValue().set("stus","");
            System.out.println("==============>db中数据 刷新了 redis 中数据 需要清理");

        }

    }

}


