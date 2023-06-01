package com.zhangchuang.complex.mapper;

import com.zhangchuang.complex.entity.StudentLastScore;
import org.apache.ibatis.annotations.Mapper;

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
}
