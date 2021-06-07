package com.example;

import redis.clients.jedis.Jedis;

public class TestList {

    public static void main(String[] args) {

        //新建Jedis对象
        Jedis jedis = new Jedis("127.0.0.1",6379);

        System.out.println("清空数据："+jedis.flushDB());
        System.out.println("新建一个list并从左端插入值('mylist',值为：'value1','value2','value3','value4','value5','value6','value7')："+jedis.lpush("mylist","value1","value2","value3","value4","value5","value6","value7"));
        System.out.println("获得mylist所有元素："+jedis.lrange("mylist",0,-1));
        System.out.println("获得mylist区间1-2的元素："+jedis.lrange("mylist",1,2));
        System.out.println("删除1个值为'value3'的元素："+jedis.lrem("mylist",1,"value3"));
        System.out.println("获得mylist所有元素："+jedis.lrange("mylist",0,-1));
        System.out.println("删除mylist区间1-4之外的元素："+jedis.ltrim("mylist",1,4));
        System.out.println("获得mylist所有元素："+jedis.lrange("mylist",0,-1));
        System.out.println("mylist出栈(左端)："+jedis.lpop("mylist"));
        System.out.println("获得mylist所有元素："+jedis.lrange("mylist",0,-1));
        System.out.println("从mylist右端插入元素'valueadd'："+jedis.rpush("mylist","valueadd"));
        System.out.println("获得mylist所有元素："+jedis.lrange("mylist",0,-1));
        System.out.println("mylist出栈(右端)："+jedis.rpop("mylist"));
        System.out.println("获得mylist所有元素："+jedis.lrange("mylist",0,-1));
        System.out.println("修改mylist的1号元素值为‘valueChanged'："+jedis.lset("mylist",1,"valueChanged"));
        System.out.println("获得mylist所有元素："+jedis.lrange("mylist",0,-1));
        System.out.println("获得mylist的元素个数："+jedis.llen("mylist"));
        System.out.println("获得mylist的2号元素值："+jedis.lindex("mylist",2));

        System.out.println("新建一个list并从左端插入值('sortedList',值为'5','2','7','3','9')："+jedis.lpush("sortedList","5","2","7","3","9"));
        System.out.println("获得sortedList全部元素："+jedis.lrange("sortedList",0,-1));
        System.out.println("对sortedList元素排序："+jedis.sort("sortedList"));
    }
}
