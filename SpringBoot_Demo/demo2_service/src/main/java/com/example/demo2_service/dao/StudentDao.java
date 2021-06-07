package com.example.demo2_service.dao;

import org.springframework.stereotype.Repository;

/**
 * 数据访问层
 */
@Repository
public class StudentDao {

    String studentDaoString = new String("from StudentDao");

    /**
     * 得到Dao层数据
     *
     * @return
     */
    public String getStudentDaoString() {
        return studentDaoString;
    }
}
