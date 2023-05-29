package com.zhangchuang.complex.service.impl;

import com.zhangchuang.complex.entity.Student;
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

    /**
     * 查询小组列表
     *
     * @param student 参数
     * @return 小组列表
     */
    @Override
    public List<Student> selectStudentGroupList(Student student) {
        List<Student> list = studentGroupMapper.selectStudentList(student);
        for (Student info : list) {
            if (studentGroupMapper.queryGroupStatus(info.getGroupId()) > 0) {
                info.setStatus("0");
            } else {
                info.setStatus("1");
            }
        }
        return list;
    }
}
