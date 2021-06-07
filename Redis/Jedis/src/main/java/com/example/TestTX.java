package com.example;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTX {

    public static void main(String[] args) {

        //新建Jedis对象
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        //清空数据
        jedis.flushDB();

        //新建JSONObject对象
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username","zhangsan");
        jsonObject.put("age","18");

        //开启事务
        Transaction multi = jedis.multi();
        String result = jsonObject.toJSONString();

        try {
            multi.set("user1",result);
            multi.set("user2",result);

            multi.exec();       //执行事务
        } catch (Exception e) {
            multi.discard();    //放弃事务
            e.printStackTrace();
        } finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();      //关闭连接
        }
    }
}
