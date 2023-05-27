package com.zhangchuang.complex.service;

import com.zhangchuang.complex.entity.StudentGrade;

import java.util.List;

/**
 * @author Zhangchuang
 * @create 2023/5/25 21:34
 */
public interface SmallGroupService {

    /**
     * 获取当前小组成员列表
     *
     * @return 小组成员列表
     */
    List<StudentGrade> selectGroupList(StudentGrade studentGrade, String username);

    /**
     * 修改成绩信息
     *
     * @param studentGrade 参数
     * @return 返回修改结果
     */
    Integer updateRating(StudentGrade studentGrade);


    /**
     * 检查是否提交过
     *
     * @param username 学生学号
     * @return 返回结果
     */
    Integer checkStatus(String username);


}
