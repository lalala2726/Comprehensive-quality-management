package com.zhangchuang.complex.mapper;

import com.zhangchuang.complex.entity.StudentGrade;
import org.apache.ibatis.annotations.Mapper;

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
}
