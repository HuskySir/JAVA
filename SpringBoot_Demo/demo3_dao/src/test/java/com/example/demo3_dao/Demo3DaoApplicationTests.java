package com.example.demo3_dao;

import com.example.demo3_dao.dao.StudentDao;
import com.example.demo3_dao.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class Demo3DaoApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    StudentDao studentDao;

    /**
     * 测试查看数据源
     * @throws SQLException
     */
    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());

        Connection connection = dataSource.getConnection();
        System.out.println("数据源："+connection);
        connection.close();
    }

    /**
     * 测试添加学生
     */
    @Test
    public void AddStudent() {

        //默认一个学生信息
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        student.setScore(100);
        student.setBirthplace("四川");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = simpleDateFormat.parse("2020-02-02");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        student.setBirthday(date);

        //在控制台输出学生信息
        System.out.println("学生信息："+student);
        //将学生信息存入数据库
        studentDao.AddStudent(student);
    }

    /**
     * 测试查找学生
     * @return
     */
    @Test
    public void FindStudentById() {

        //从数据库查找学生
        Student student = studentDao.FindStudentById(2);
        //在控制台输出学生信息
        System.out.println("查找的学生信息："+student);
    }

    /**
     * 测试修改学生
     */
    @Test
    public void UpdateStudent() {

        //默认一个学生信息
        Student student = new Student();
        //待修改学生的学号
        student.setId(1);
        //修改其他信息
        student.setName("张三");
        student.setScore(60);
        student.setBirthplace("新疆");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = simpleDateFormat.parse("2020-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        student.setBirthday(date);

        //在控制台输出学生信息
        System.out.println("修改后的学生信息："+student);
        //修改学生信息
        studentDao.UpdateStudent(student);
    }

    /**
     * 测试删除学生
     */
    @Test
    public void DeleteStudentById() {

        //删除学号为2的学生
        studentDao.DeleteStudentById(1);
    }

}
