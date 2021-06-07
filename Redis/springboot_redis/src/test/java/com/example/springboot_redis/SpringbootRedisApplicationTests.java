package com.example.springboot_redis;

import com.example.springboot_redis.pojo.User;
import com.example.springboot_redis.utils.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringbootRedisApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {

        /*
        * redisTemplate 操作不同的数据类型
        * opsForValue 操作字符串 类似String
        * opsForList 操作列表 类似List
        * opsForSet 操作集合 类似Set
        * opsForZSet 操作有序集合 类似ZSet
        * opsForHash 操作散列表 类似Hash
        * opsForGeo 类似Geospatial
        * opsForHyperLogLog 类似Hyperloglog
        * */
        redisTemplate.opsForValue().set("username","zhangsan");             //新增key-value <'username','zhangsan'>
        System.out.println(redisTemplate.opsForValue().get("username"));;   //输出'username'对应值

        //获取redis的连接对象
        //RedisConnection redisConnection = redisTemplate.getConnectionFactory().getConnection();
    }

    @Test
    public void test() throws JsonProcessingException {

        //新建一个User对象
        User user = new User();
        user.setName("zhangsan");
        user.setAge(18);

        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

    @Test
    public void test1() {

        redisUtil.set("name","zhangsan");
        System.out.println(redisUtil.get("name"));
    }
}
