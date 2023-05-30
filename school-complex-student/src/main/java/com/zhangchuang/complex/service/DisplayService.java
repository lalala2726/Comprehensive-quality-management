package com.zhangchuang.complex.service;

import com.zhangchuang.complex.entity.DisplayGroup;

import java.util.HashMap;

/**
 * @author Zhangchuang
 * @create 2023/5/28 21:00
 */
public interface DisplayService {


    /**
     * 根据ID获取指定小组的成绩信息
     *
     * @param id 小组ID
     * @return 返回小组成绩信息
     */
    DisplayGroup getGroupDataById(Integer id);

    /**
     * 展示学生成绩数据
     *
     * @return 数据
     */
    HashMap<String, Object> displayDashboardData();
}
