package com.zhangchuang.complex.mapper;

import com.zhangchuang.complex.entity.StudentLastScore;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Zhangchuang
 * @create 2023/6/1 13:45
 */
@Mapper
public interface LastScoreMapper {

    /**
     * 获取学生上次成绩信息列表
     *
     * @param studentLastScore 参数
     * @return 返回列表
     */
    List<StudentLastScore> selectStudentLastScoreList(StudentLastScore studentLastScore);


    /**
     * 根据ID查询学生详细信息
     *
     * @param id 学生ID
     * @return 成绩信息
     */
    StudentLastScore getStudentDetailById(@Param("id") String id);

    /**
     * 修改成绩信息
     *
     * @param studentLastScore 参数
     * @return 修改结果
     */
    Integer updateStudentScore(StudentLastScore studentLastScore);
}
