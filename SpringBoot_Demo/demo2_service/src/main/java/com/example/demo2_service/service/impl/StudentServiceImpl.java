package com.example.demo2_service.service.impl;

import com.example.demo2_service.dao.StudentDao;
import com.example.demo2_service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务层
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    /**
     * 通过前端传入数据计算斐波那契数列值
     *
     * @param number
     * @return
     */
    @Override
    public Integer getFibonacciResult(Integer number) {

        if (number == 1 || number == 2) {
            return 1;
        } else {
            return getFibonacciResult(number - 1) + getFibonacciResult(number - 2);
        }
    }

    /**
     * 得到Dao层数据
     *
     * @return
     */
    @Override
    public String getStudentDaoString() {
        return studentDao.getStudentDaoString();
    }
}
