package com.example.demo1_controller.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Student类 学生实体类
 */
public class Student implements Serializable {

    private Integer id;         //学号
    private String name;        //姓名
    private Integer score;      //成绩
    private String birthplace;  //籍贯
    //日期的格式 年-月-日
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;      //生日

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", birthplace='" + birthplace + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
