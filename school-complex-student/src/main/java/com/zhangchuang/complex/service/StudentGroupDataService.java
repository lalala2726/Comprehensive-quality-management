package com.zhangchuang.complex.service;

import com.zhangchuang.complex.entity.GroupStudentDataInfo;

import java.util.List;

/**
 * @author Zhangchuang
 * @create 2023/5/23 13:44
 */
public interface StudentGroupDataService {


    /**
     * 查询小组学生列表
     *
     * @param groupId 小组ID
     * @return 学生列表
     */
    List<GroupStudentDataInfo> selectGroupStudentList(Long groupId);


    /**
     * 搜索小组成员信息
     *
     * @param groupStudentDataInfo 信息
     * @return 小组成员信息
     */
    List<GroupStudentDataInfo> serachGroupStudentList(GroupStudentDataInfo groupStudentDataInfo);


    /**
     * 删除小组成员
     *
     * @param ids 学生学号
     */
    Integer removeStudent(Long[] ids);
}
