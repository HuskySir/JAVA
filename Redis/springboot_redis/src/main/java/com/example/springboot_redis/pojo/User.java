package com.example.springboot_redis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.io.Serializable;

@Component          //注解在类上，声明由spring容器管理
@AllArgsConstructor //注解在类上,为类提供一个含有所有已声明字段属性参数的构造方法
@NoArgsConstructor  //注解在类上,为类提供一个无参的构造方法
@Data               //注解在类上,为类提供读写属性, 此外还提供了equals()、hashCode()、toString()方法
public class User implements Serializable {

    private String name;
    private int age;
}
