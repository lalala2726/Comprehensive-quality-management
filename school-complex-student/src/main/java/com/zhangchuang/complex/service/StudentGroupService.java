package com.zhangchuang.complex.service;

import com.zhangchuang.complex.entity.Student;

import java.util.List;

/**
 * @author Zhangchuang
 * @create 2023/5/23 0:34
 */
public interface StudentGroupService {

    List<Student> selectStudentGroupList(Student student);
}
