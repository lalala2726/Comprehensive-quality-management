package com.zhangchuang.complex.mapper;

import com.zhangchuang.complex.entity.StudentGrade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Zhangchuang
 * @create 2023/5/24 17:41
 */
@Mapper
public interface RatingsMapper {
    /**
     * 查询学生成绩列表
     *
     * @param studentGrade 参数
     * @return 成绩列表
     */
    List<StudentGrade> selectRatingList(StudentGrade studentGrade);

    /**
     * 通过学生ID获取详细信息
     *
     * @param id 学生ID
     * @return 返回结果
     */
    StudentGrade getRatingInfoById(@Param("id") String id);

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
    Integer checkStudentExist(@Param("id") String id);

    /**
     * 检查成绩表是否包含学生成绩
     *
     * @param id 学生id
     * @return 返回结果
     */
    Integer checkRatingExist(@Param("id") String id);

    /**
     * 添加学生成绩信息
     *
     * @param studentGrade 参数信息
     * @return 返回结果
     */
    Integer addStudentRating(StudentGrade studentGrade);

    /**
     * 删除学生成绩信息
     *
     * @param id 参数
     * @return 返回删除结果
     */
    Integer delete(@Param("id") String id);


    /**
     * 提交状态信息修改
     *
     * @param status 参数
     * @return 修改结果
     */
    Integer submitChange(Integer status);

    /**
     * 重置所有学生的分数
     *
     * @return 返回执行结果
     */
    Integer resetScore();
}
