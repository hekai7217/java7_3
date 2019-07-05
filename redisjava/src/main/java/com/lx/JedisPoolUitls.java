package com.lx;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 通过连接池 获取jedis连接
 */
public class JedisPoolUitls {

    private static JedisPool pool = null;

    static {
        Properties pro = new Properties();
        // 加载配置文件
        try {
            File f = new File("./");
            System.out.println(f.getAbsoluteFile());
            pro.load(new FileInputStream(new File("redisjava/src/main/resources/jedis.properties")));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 获得池子对象
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(Integer.parseInt(pro.get("redis.maxIdle").toString()));// 最大闲置个数
        poolConfig.setMinIdle(Integer.parseInt(pro.get("redis.minIdle").toString()));// 最小闲置个数
        poolConfig.setMaxTotal(Integer.parseInt(pro.get("redis.maxTotal").toString()));// 最大连接数
        pool = new JedisPool(poolConfig, pro.getProperty("redis.url"),
                Integer.parseInt(pro.get("redis.port").toString()));
    }

    //获取 jedis 资源的方法
    public static Jedis getJedis() {
        // 获取资源
        return pool.getResource();
    }

    public static void main(String[] args) {
        System.out.println(JedisPoolUitls.getJedis().ping());
    }


}



