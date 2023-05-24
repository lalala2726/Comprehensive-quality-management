package com.zhangchuang.complex.mapper;

import com.zhangchuang.complex.entity.GroupStudentDataInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Zhangchuang
 * @create 2023/5/23 14:55
 */
@Mapper
public interface StudentGroupDataMapper {


    /**
     * 通过小组ID获取小组成员信息
     *
     * @param groupId 小组成员信息
     * @return 小组成员
     */
    List<GroupStudentDataInfo> selectGroupStudentList(Long groupId);


    /**
     * 搜索小组成员信息
     *
     * @param groupStudentDataInfo 信息
     * @return 小组成员信息
     */
    List<GroupStudentDataInfo> searchGroupStudentList(GroupStudentDataInfo groupStudentDataInfo);

    /**
     * 将学生从小组中移除
     *
     * @param id 学生学号
     * @return 返回移除结果
     */
    int removeStudent(Long[] id);
}
