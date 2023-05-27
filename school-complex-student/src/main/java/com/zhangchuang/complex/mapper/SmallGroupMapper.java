package com.zhangchuang.complex.mapper;

import com.zhangchuang.complex.entity.ManageGroup;
import com.zhangchuang.complex.entity.GroupStudentDataInfo;
import com.zhangchuang.complex.entity.StudentGrade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Zhangchuang
 * @create 2023/5/25 21:35
 */
@Mapper
public interface SmallGroupMapper {

    /**
     * 获取当前小组的成绩信息
     *
     * @return 小组成员列表
     */
    List<StudentGrade> selectGroupList(StudentGrade studentGrade, @Param("manageGroup") Integer groupId);


    /**
     * 查询用户所管理的小组信息
     *
     * @param username 用户账号
     * @return 返回小组编号
     */
    ManageGroup QueryGroup(String username);
}
