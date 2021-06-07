package com.example;

import redis.clients.jedis.Jedis;
import java.util.Set;

public class TestKey {

    public static void main(String[] args) {

        //新建Jedis对象
        Jedis jedis = new Jedis("127.0.0.1",6379);

        System.out.println("清空数据："+jedis.flushDB());
        System.out.println("判断某个值是否存在："+jedis.exists("username"));
        System.out.println("新增<'username','zhangsan'>键值对："+jedis.set("username","zhangsan"));
        System.out.println("新增<'password','123'>键值对："+jedis.set("password","123"));
        System.out.println("系统中所有键如下：");
        Set<String> keys =jedis.keys("*");
        System.out.println(keys);
        System.out.println("删除键password："+jedis.del("password"));
        System.out.println("判断password是否存在："+jedis.exists("password"));
        System.out.println("查看username所存储的值的数据类型："+jedis.type("username"));
        System.out.println("新增<'score','100'>键值对："+jedis.set("score","100"));
        System.out.println("随机返回所有key中的一个："+jedis.randomKey());
        System.out.println("重命名key："+jedis.rename("username","name"));
        System.out.println("取出修改后的key："+jedis.get("name"));
        System.out.println("按索引查询："+jedis.select(0));
        System.out.println("删除当前数据库中的所有key："+jedis.flushDB());
        System.out.println("返回当前数据库中key的数目："+jedis.dbSize());
        System.out.println("删除所有数据库中的所有key："+jedis.flushAll());
    }
}
