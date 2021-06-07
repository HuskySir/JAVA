package com.example.demo2_service.controller;

import com.example.demo2_service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制层
 */
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    /**
     * 前端输入初始值，返回斐波那契数列值
     *
     * @param number
     * @return
     */
    @RequestMapping("/getFibonacciResult")
    public Integer getFibonacciResult(Integer number) {

        return studentService.getFibonacciResult(number);
    }

    /**
     * 通过Service层得到Dao层的数据
     *
     * @return
     */
    @RequestMapping("/getStudentDaoString")
    public String getStudentDaoString() {
        return studentService.getStudentDaoString();
    }
}
