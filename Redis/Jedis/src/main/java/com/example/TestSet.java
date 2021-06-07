package com.example;

import redis.clients.jedis.Jedis;

public class TestSet {

    public static void main(String[] args) {

        //新建Jedis对象
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        System.out.println("清空数据：" + jedis.flushDB());
        System.out.println("新建一个set并添加元素('myset',值为：‘s1','s3',,'s5','s2','s4','s6')："+jedis.sadd("myset","s1","s3","s5","s2","s4","s6"));
        System.out.println("向set添加元素's6'："+jedis.sadd("myset","s6"));
        System.out.println("获得myset所有元素："+jedis.smembers("myset"));
        System.out.println("删除一个元素's3'："+jedis.srem("myset","s3"));
        System.out.println("获得myset所有元素："+jedis.smembers("myset"));
        System.out.println("删除两个元素's4'与's6'："+jedis.srem("myset","s4","s6"));
        System.out.println("获得myset所有元素："+jedis.smembers("myset"));
        System.out.println("随机移除myset中的一个元素："+jedis.spop("myset"));
        System.out.println("获得myset所有元素："+jedis.smembers("myset"));
        System.out.println("myset中元素的个数："+jedis.scard("myset"));
        System.out.println("'s5'是否在myset中："+jedis.sismember("myset","s5"));
        System.out.println("'s2'是否在myset中："+jedis.sismember("myset","s2"));

        System.out.println("新建一个set并添加元素('myset1',值为：'s1','s2','s4','s5','s6)："+jedis.sadd("myset1","s1","s2","s4","s5","s6"));
        System.out.println("新建一个set并添加元素('myset2',值为：'s2','s3','s6')："+jedis.sadd("myset2","s2","s3","s6"));
        System.out.println("获得myset1所有元素："+jedis.smembers("myset1"));
        System.out.println("获得myset2所有元素："+jedis.smembers("myset2"));
        System.out.println("移除myset1中的's1'元素并在myset2中添加's1'元素："+jedis.smove("myset1","myset2","s1"));
        System.out.println("移除myset1中的's2'元素并在myset2中添加's2'元素："+jedis.smove("myset1","myset2","s2"));
        System.out.println("获得myset1所有元素："+jedis.smembers("myset1"));
        System.out.println("获得myset2所有元素："+jedis.smembers("myset2"));
        System.out.println("myset1与myset2的交集："+jedis.sinter("myset1","myset2"));
        System.out.println("myset1与myset2的并集："+jedis.sunion("myset1","myset2"));
        System.out.println("myset1与myset2的差集："+jedis.sdiff("myset1","myset2"));
        System.out.println("求myset1与myset2的交集并将数据存储myset3中："+jedis.sinterstore("myset3","myset1","myset2"));
        System.out.println("获得myset3所有元素："+jedis.smembers("myset3"));
        System.out.println("求myset1与myset2的并集并将数据存储myset4中："+jedis.sunionstore("myset4","myset1","myset2"));
        System.out.println("获得myset4所有元素："+jedis.smembers("myset4"));
        System.out.println("求myset1与myset2的差集并将数据存储myset5中："+jedis.sdiffstore("myset5","myset1","myset2"));
        System.out.println("获得myset5所有元素："+jedis.smembers("myset5"));
    }
}
