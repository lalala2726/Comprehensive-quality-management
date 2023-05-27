package com.zhangchuang.complex.service;

import com.zhangchuang.complex.entity.GroupStudentDataInfo;
import com.zhangchuang.complex.entity.StudentGrade;

import java.util.List;

/**
 * @author Zhangchuang
 * @create 2023/5/25 21:34
 */
public interface SmallGroupService {

    /**
     * 获取当前小组成员列表
     *
     * @return 小组成员列表
     */
    List<StudentGrade> selectGroupList(StudentGrade studentGrade, String username);

}
