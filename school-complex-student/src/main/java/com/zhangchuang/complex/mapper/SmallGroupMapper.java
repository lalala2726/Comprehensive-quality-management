package com.zhangchuang.complex.mapper;

import com.zhangchuang.complex.entity.GroupManage;
import com.zhangchuang.complex.entity.GroupStudentDataInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Zhangchuang
 * @create 2023/5/25 21:35
 */
@Mapper
public interface SmallGroupMapper {

    /**
     * 获取当前小组成员列表
     *
     * @return 小组成员列表
     */
    List<GroupStudentDataInfo> selectGroupList(GroupStudentDataInfo groupStudentDataInfo);


    /**
     * 查询用户所管理的小组信息
     *
     * @param username 用户账号
     * @return 返回小组编号
     */
    GroupManage QueryGroup(String username);
}
