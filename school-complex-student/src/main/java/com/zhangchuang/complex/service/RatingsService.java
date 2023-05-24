package com.zhangchuang.complex.service;

import com.zhangchuang.complex.entity.StudentGrade;

import java.util.List;

/**
 * @author Zhangchuang
 * @create 2023/5/24 17:40
 */
public interface RatingsService {
    /**
     * 查询学生成绩信息
     *
     * @param studentGrade 参数
     * @return 学生成绩列表
     */
    List<StudentGrade> selectRatingsList(StudentGrade studentGrade);
}
