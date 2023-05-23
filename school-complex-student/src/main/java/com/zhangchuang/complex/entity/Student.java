package com.zhangchuang.complex.entity;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @author Zhangchuang
 * @create 2023/5/23 13:44
 */
public class Student extends BaseEntity {

    /**
     * 学生ID
     */
    private Long stu_id;

    /**
     * 学生姓名
     */
    private String stu_name;

    /**
     * 班级ID
     */
    private Long class_id;

    /**
     * 组ID
     */
    private Integer group_id;


    /**
     * 状态
     */
    private String status;

}
