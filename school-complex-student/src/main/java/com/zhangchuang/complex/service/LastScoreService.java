package com.zhangchuang.complex.service;

import com.zhangchuang.complex.entity.StudentLastScore;

import java.util.List;

/**
 * @author Zhangchuang
 * @create 2023/6/1 13:44
 */
public interface LastScoreService {

    /**
     * 获取学生上次成绩信息列表
     *
     * @param studentLastScore 参数
     * @return 返回列表
     */
    List<StudentLastScore> selectStudentLastScoreList(StudentLastScore studentLastScore);
}
