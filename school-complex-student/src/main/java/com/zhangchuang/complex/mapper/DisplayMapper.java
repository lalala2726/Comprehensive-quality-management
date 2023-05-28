package com.zhangchuang.complex.mapper;

import com.zhangchuang.complex.entity.StudentGrade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Zhangchuang
 * @create 2023/5/28 21:04
 */
@Mapper
public interface DisplayMapper {

    /**
     * 根据ID获取指定小组的成绩信息
     *
     * @param id 小组ID
     * @return 返回小组成绩信息
     */
    List<StudentGrade> getGroupDataById(@Param("groupId") Integer id);
}
