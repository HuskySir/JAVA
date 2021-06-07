package com.example.demo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Student类 学生实体类
 */
@ApiModel(value = "Student",description = "用户实体类")
public class Student implements Serializable {

    @ApiModelProperty(value = "学号")
    private Integer id;         //学号
    @ApiModelProperty(value = "姓名")
    private String name;        //姓名
    @ApiModelProperty(value = "成绩")
    private Integer score;      //成绩
    @ApiModelProperty(value = "籍贯")
    private String birthplace;  //籍贯
    //日期的格式 年-月-日
    @ApiModelProperty(value = "生日")
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
