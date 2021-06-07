package com.example.demo.service.impl;

import com.example.demo.dao.StudentDao;
import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * StudentServiceImpl 业务层类
 */
@Service(value = "StudentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    /**
     * 添加学生信息
     * @param student
     */
    @Override
    public void AddStudent(Student student) {
        studentDao.AddStudent(student);
    }

    /**
     * 删除学生信息
     * @param id
     */
    @Override
    public void DeleteStudentById(Integer id) {
        studentDao.DeleteStudentById(id);
    }

    /**
     * 修改学生信息
     * @param student
     */
    @Override
    public void UpdateStudent(Student student) {
        studentDao.UpdateStudent(student);
    }

    /**
     * 查询某个学生信息
     * @param id
     * @return
     */
    @Override
    public Student FindStudentById(Integer id) {
        return studentDao.FindStudentById(id);
    }

    /**
     * 查询所有学生信息
     * @return
     */
    @Override
    public List<Student> FindAllStudent() {
        return studentDao.FindAllStudent();
    }
}
