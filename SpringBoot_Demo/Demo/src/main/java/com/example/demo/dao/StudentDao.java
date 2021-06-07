package com.example.demo.dao;

import com.example.demo.domain.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * StudentDao 数据访问层
 */
@Mapper
@Repository(value = "StudentDao")
public interface StudentDao {

    /**
     * 添加学生信息
     * @param student
     */
    public void AddStudent(Student student);

    /**
     * 删除学生信息
     * @param id
     */
    public void DeleteStudentById(Integer id);

    /**
     * 修改学生信息
     * @param student
     */
    public void UpdateStudent(Student student);

    /**
     * 查找某个学生信息
     * @param id
     * @return
     */
    public Student FindStudentById(Integer id);

    /**
     * 查找所有学生信息
     * @return
     */
    public List<Student> FindAllStudent();

}
