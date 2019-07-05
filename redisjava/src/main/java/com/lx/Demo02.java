package com.lx;

import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;

public class Demo02 {

    public static void main(String[] args) {

        // 对象如何存储

        User u = new User("soctt", "tiger");

        Jedis jedis = JedisPoolUitls.getJedis();

        // 把 user 转出 json子字符串
        String uJson = JSON.toJSONString(u);
        //把json字符串 存储到 redis中

        jedis.set("u", uJson);

        // 从redis中获取 json字符串 转成  user
        User user = JSON.parseObject(jedis.get("u"),User.class);

        System.out.println(user.getName());

        // 资源回收
        jedis.close();
    }
}
