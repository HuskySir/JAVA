package com.example.demo1_controller.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * 视图控制器
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //初始页面设置为"student/studentlist"
        //第一次参数为指定访问路径，第二个参数为指定访问视图名
        registry.addViewController("/").setViewName("student/studentlist");
    }
}
