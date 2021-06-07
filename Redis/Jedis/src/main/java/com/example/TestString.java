package com.example;

import redis.clients.jedis.Jedis;
import java.util.concurrent.TimeUnit;

public class TestString {

    public static void main(String[] args) {

        //新建Jedis对象
        Jedis jedis = new Jedis("127.0.0.1",6379);

        System.out.println("清空数据："+jedis.flushDB());
        System.out.println("新增键值对<'key1','value1'>："+jedis.set("key1","value1"));
        System.out.println("新增键值对<'key2','value2'>："+jedis.set("key2","value2"));
        System.out.println("新增键值对<'key3','value3'>："+jedis.set("key3","value3"));
        System.out.println("删除键key2："+jedis.del("key2"));
        System.out.println("获得键key2对应值："+jedis.get("key2"));
        System.out.println("修改key1对应值："+jedis.set("key1","value1Changed"));
        System.out.println("获得key1对应值："+jedis.get("key1"));
        System.out.println("在key3后面加入值："+jedis.append("key3","End"));
        System.out.println("获得key3对应值："+jedis.get("key3"));
        System.out.println("增加多个键值对<'key01','value01'>、<'key02',value02'>、<'key03','value03'>："+jedis.mset("key01","value01","key02","value02","key03","value03"));
        System.out.println("获得多个键的对应值('key01','key02','key03')："+jedis.mget("key01","key02","key03"));
        System.out.println("删除多个键值对('key01','key02')："+jedis.del("key01","key02"));
        System.out.println("获得多个键的对应值('key01','key02','key03')："+jedis.mget("key01","key02","key03"));

        System.out.println("清空数据："+jedis.flushDB());
        System.out.println("不存在键值对<'key1','value1'>则新增："+jedis.setnx("key1","value1"));
        System.out.println("不存在键值对<'key2','value2'>则新增："+jedis.setnx("key2","value2"));
        System.out.println("不存在键值对<'key2','value2-new'>则新增："+jedis.setnx("key2","value2-new"));
        System.out.println("获得key1对应值："+jedis.get("key1"));
        System.out.println("获得key2对应值："+jedis.get("key2"));
        System.out.println("新增键值对<'key3','value3'>并设置有效时间为2秒："+jedis.setex("key3",2,"value3"));
        System.out.println("获得key3对应值："+jedis.get("key3"));
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("获得key3对应值："+jedis.get("key3"));

        System.out.println("获得key2对应值并修改为key2GetSet："+jedis.getSet("key2","key2GetSet"));
        System.out.println("获得key2对应值："+jedis.get("key2"));
        System.out.println("获得key2对应值区间为2-4的字符串："+jedis.getrange("key2",2,4));
    }
}
