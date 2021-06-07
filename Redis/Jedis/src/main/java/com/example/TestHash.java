package com.example;

import redis.clients.jedis.Jedis;
import java.util.HashMap;
import java.util.Map;

public class TestHash {

    public static void main(String[] args) {

        //新建Jedis对象
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        System.out.println("清空数据：" + jedis.flushDB());
        //新建map对象并赋值
        Map<String,String> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");

        System.out.println("新建hash并添加元素('myhash',值为map)："+jedis.hmset("myhash",map));
        System.out.println("向myhash中添加键值对(key：'key5',value：'value5')："+jedis.hset("myhash","key5","value5"));
        System.out.println("获得myhash所有元素："+jedis.hgetAll("myhash"));
        System.out.println("获得myhash所有键："+jedis.hkeys("myhash"));
        System.out.println("获得myhash所有值："+jedis.hvals("myhash"));
        System.out.println("如果myhash不存在'key6'键,则添加键值对key：'key6',value：'value6'："+jedis.hsetnx("myhash","key6","value6"));
        System.out.println("获得myhash所有元素："+jedis.hgetAll("myhash"));
        System.out.println("如果myhash不存在'key6'键,则添加键值对key：'key6',value：'value6_new'："+jedis.hsetnx("myhash","key6","value6_new"));
        System.out.println("获得myhash所有元素："+jedis.hgetAll("myhash"));
        System.out.println("删除myhash的’key3'与'key4'键："+jedis.hdel("myhash","key3","key4"));
        System.out.println("获得myhash所有元素："+jedis.hgetAll("myhash"));
        System.out.println("获得myhash的元素个数："+jedis.hlen("myhash"));
        System.out.println("判断myhash中是否存在'key1'："+jedis.hexists("myhash","key1"));
        System.out.println("判断myhash中是否存在'key3'："+jedis.hexists("myhash","key3"));
        System.out.println("获得myhash中'key1'的值："+jedis.hmget("myhash","key1"));
        System.out.println("获得myhash中'key2'、'key3'的值："+jedis.hmget("myhash","key2","key3"));
    }
}
