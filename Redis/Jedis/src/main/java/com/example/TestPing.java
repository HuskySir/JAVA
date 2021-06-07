package com.example;

import redis.clients.jedis.Jedis;

public class TestPing {
    public static void main(String[] args) {

        //新建Jedis对象
        Jedis jedis = new Jedis("127.0.0.1",6379);
        //输出连接状态
        System.out.println(jedis.ping());
        //关闭连接
        jedis.close();
    }
}