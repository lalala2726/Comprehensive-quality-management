package com.zhangchuang.complex.service.impl;

import com.zhangchuang.complex.entity.StudentGroup;
import com.zhangchuang.complex.mapper.StudentGroupMapper;
import com.zhangchuang.complex.service.StudentGroupService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zhangchuang
 * @create 2023/5/23 0:35
 */
@Service
public class StudentGroupServiceImpl implements StudentGroupService {

    private final StudentGroupMapper studentGroupMapper;

    public StudentGroupServiceImpl(StudentGroupMapper studentGroupMapper) {
        this.studentGroupMapper = studentGroupMapper;
    }

    @Override
    public List<StudentGroup> selectStudentGroupList(StudentGroup studentGroup) {
        return studentGroupMapper.selectStudentList(studentGroup);
    }
}