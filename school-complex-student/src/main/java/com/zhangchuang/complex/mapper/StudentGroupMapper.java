package com.zhangchuang.complex.mapper;

import com.zhangchuang.complex.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Zhangchuang
 * @create 2023/5/23 0:45
 */
@Mapper
public interface StudentGroupMapper {
    /**
     * 获取小组列表
     *
     * @param student 小组信息
     * @return 小组信息
     */
    List<Student> selectStudentList(Student student);


    /**
     * 查询小组提交状态信息
     *
     * @return 小组未提交的数量
     */
    Integer queryGroupStatus(@Param("groupId") Integer groupId);
}
