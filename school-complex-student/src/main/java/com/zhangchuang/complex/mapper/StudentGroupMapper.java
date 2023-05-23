package com.zhangchuang.complex.mapper;

import com.zhangchuang.complex.entity.StudentGroup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Zhangchuang
 * @create 2023/5/23 0:45
 */
@Mapper
public interface StudentGroupMapper {
    List<StudentGroup> selectStudentList(StudentGroup studentGroup);
}
