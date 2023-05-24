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
    StudentGrade getRatingInfoById(@Param("id") Long id);

    /**
     * 修改成绩信息
     *
     * @param studentGrade 参数
     * @return 返回修改结果
     */
    Integer updateRating(StudentGrade studentGrade);
}
