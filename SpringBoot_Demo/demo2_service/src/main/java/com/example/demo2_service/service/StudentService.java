package com.example.demo2_service.service;

/**
 * 业务层
 */
public interface StudentService {

    /**
     * 通过前端传入数据计算斐波那契数列值
     *
     * @param number
     * @return
     */
    public Integer getFibonacciResult(Integer number);

    /**
     * 得到Dao层数据
     *
     * @return
     */
    public String getStudentDaoString();

}
