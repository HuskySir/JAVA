package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * StudentController 控制层
 */
/*@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;*/

    /**
     * 来到学生信息页面
     * @return
     */
/*    @GetMapping(value = "/student")
    public String ToStudent() {

        return "student/studentinfo";
    }*/

    /**
     * 添加学生信息
     * @param student
     * @return
     */
/*    @PostMapping(value = "/student")
    public String AddStudent(Student student) {

        studentService.AddStudent(student);
        return "redirect:/students";
    }*/

    /**
     * 删除学生信息
     * @param id
     * @return
     */
/*    @DeleteMapping(value = "/student/{id}")
    public String DeleteStudentById(@PathVariable("id") Integer id) {

        studentService.DeleteStudentById(id);
        return "redirect:/students";
    }*/

    /**
     * 修改学生信息
     * @param student
     * @return
     */
/*    @PutMapping(value = "/student")
    public String UpdateStudent(Student student) {

        //得到数据库中的学生信息
        Student updatestudent = studentService.FindStudentById(student.getId());
        //修改该学生信息
        updatestudent.setName(student.getName());
        updatestudent.setScore(student.getScore());
        updatestudent.setBirthplace(student.getBirthplace());
        updatestudent.setBirthday(student.getBirthday());
        //更新信息
        studentService.UpdateStudent(student);
        return "redirect:/students";
    }*/

    /**
     * 查找某个学生信息
     * @param id
     * @param model
     * @return
     */
/*    @GetMapping(value = "/student/{id}")
    public String FindStudentById(@PathVariable("id") Integer id,Model model) {

        //通过学生学号得到需要修改学生的学生信息
        Student student = studentService.FindStudentById(id);
        model.addAttribute("student",student);
        return "student/studentinfo";
    }*/

    /**
     * 查找所有学生信息
     * @param model
     * @return
     */
/*    @GetMapping(value = "/students")
    public String FindAllStudent(Model model) {

        List<Student> students = studentService.FindAllStudent();
        model.addAttribute("students",students);
        return "student/studentlist";
    }
}*/


/**
 * StudentController控制层 仅与前端交互数据
 */
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ApiOperation("添加学生信息")
    @PostMapping(value = "/student")
    public void AddStudent(Student student) {

        studentService.AddStudent(student);
    }

    @ApiOperation("删除学生信息")
    @DeleteMapping(value = "/student/{id}")
    public void DeleteStudentById(@PathVariable("id") Integer id) {

        studentService.DeleteStudentById(id);
    }

    @ApiOperation("修改学生信息")
    @PutMapping(value = "/student")
    public void UpdateStudent(Student student) {

        //得到数据库中的学生信息
        Student updatestudent = studentService.FindStudentById(student.getId());
        //修改该学生信息
        updatestudent.setName(student.getName());
        updatestudent.setScore(student.getScore());
        updatestudent.setBirthplace(student.getBirthplace());
        updatestudent.setBirthday(student.getBirthday());
        //更新信息
        studentService.UpdateStudent(student);
    }

    @ApiOperation("查询单个学生信息")
    @GetMapping(value = "/student/{id}")
    public Student FindStudentById(@PathVariable("id") Integer id) {

        //通过学生学号得到需要修改学生的学生信息
        Student student = studentService.FindStudentById(id);
        return student;
    }

    @ApiOperation("查询所有学生信息")
    @GetMapping(value = "/students")
    public List<Student> FindAllStudent(Model model) {

        List<Student> students = studentService.FindAllStudent();
        return students;
    }
}
