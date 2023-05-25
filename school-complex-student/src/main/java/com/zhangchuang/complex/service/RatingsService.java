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

    /**
     * 通过学生ID获取详细信息
     *
     * @param id 学生ID
     * @return 返回结果
     */
    StudentGrade getRatingInfoById(Long id);

    /**
     * 修改成绩信息
     *
     * @param studentGrade 参数
     * @return 返回修改结果
     */
    Integer updateRating(StudentGrade studentGrade);

    /**
     * 检查学生是否存在
     *
     * @param id studentId
     * @return 返回结果
     */
    Integer checkStudentExist(Long id);

    /**
     * 添加学生成绩信息
     *
     * @param studentGrade 参数
     * @return 结果
     */
    Integer addStudentRating(StudentGrade studentGrade);

    /**
     * 检查成绩表是否包含学生成绩
     *
     * @param id 学生id
     * @return 返回结果
     */
    Integer checkRatingExist(Long id);
}
