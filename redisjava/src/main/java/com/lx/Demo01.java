package com.lx;

import redis.clients.jedis.Jedis;

/**
 * 测试 jedis 的连接
 */
public class Demo01 {

    /**
     *   1. 查看端口是否开放了 （redis服务启动没有）
     *   2. 设置 可以远程连接  bind 0.0.0.0 或者注释
     *   3. redis 的protect mode 模式关闭
     *
     * @param args
     */
    public static void main(String[] args) {

        Jedis jedis = new Jedis("192.168.17.100",6379);
        System.out.println(jedis.ping());

        //设置  存储 一个 city shenzhen
        jedis.set("city","shenzhen");
        System.out.println(jedis.get("city"));
    }
}
