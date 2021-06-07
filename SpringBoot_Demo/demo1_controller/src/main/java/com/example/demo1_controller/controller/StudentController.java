package com.example.demo1_controller.controller;

import com.example.demo1_controller.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @ResponseBody
    @RequestMapping(value = "/helloworld")
    public String HelloWorld() {
        return "Hello World";
    }

    /**
     * 来到学生信息页面
     *
     * @return
     */
    @GetMapping(value = "/student")
    public String ToStudent() {

        return "student/studentinfo";
    }

    /**
     * 添加学生信息
     *
     * @param student
     * @return
     */
    @PostMapping(value = "/student")
    public String AddStudent(Student student) {

        //执行添加学生信息操作，本项目未连接数据库，仅在控制台输出需要存储的学生数据
        System.out.println(student);
        //跳转至学生列表页面
        return "student/studentlist";
    }

    /**
     * 查找某个学生信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/student/{id}")
    public String FindStudentById(String id) {

        //执行通过学生id从数据库查找学生信息操作，本项目未连接数据库，仅在控制台输出学生id
        System.out.println("所查找学生的学号" + id);
        //跳转至学生信息页面
        return "student/studentinfo";
    }
}
