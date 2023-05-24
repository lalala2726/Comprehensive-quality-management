package com.zhangchuang.complex.service.impl;

import com.zhangchuang.complex.entity.GroupStudentDataInfo;
import com.zhangchuang.complex.mapper.StudentGroupDataMapper;
import com.zhangchuang.complex.service.StudentGroupDataService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zhangchuang
 * @create 2023/5/23 15:04
 */
@Service
public class StudentGroupDataServiceImpl implements StudentGroupDataService {


    private final StudentGroupDataMapper studentGroupDataMapper;


    public StudentGroupDataServiceImpl(StudentGroupDataMapper studentGroupDataMapper) {
        this.studentGroupDataMapper = studentGroupDataMapper;
    }

    /**
     * 通过ID获取小组成员信息
     *
     * @param groupId 小组ID
     * @return 小组成员信息
     */
    @Override
    public List<GroupStudentDataInfo> selectGroupStudentList(Long groupId) {
        return studentGroupDataMapper.selectGroupStudentList(groupId);
    }

    /**
     * 搜索小组成员信息
     *
     * @param groupStudentDataInfo 参数
     * @return 成员信息
     */
    @Override
    public List<GroupStudentDataInfo> serachGroupStudentList(GroupStudentDataInfo groupStudentDataInfo) {
        return studentGroupDataMapper.searchGroupStudentList(groupStudentDataInfo);
    }

    /**
     * 将学生从小组中移除
     *
     * @param ids 学生学号
     * @return 返回移除结果
     */
    @Override
    public Integer removeStudent(Long[] ids) {
        return studentGroupDataMapper.removeStudent(ids);
    }
}
