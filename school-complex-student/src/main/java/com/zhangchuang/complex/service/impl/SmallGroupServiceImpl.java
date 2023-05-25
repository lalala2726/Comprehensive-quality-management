package com.zhangchuang.complex.service.impl;

import com.zhangchuang.complex.entity.GroupStudentDataInfo;
import com.zhangchuang.complex.mapper.SmallGroupMapper;
import com.zhangchuang.complex.service.SmallGroupService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zhangchuang
 * @create 2023/5/25 21:34
 */
@Service
public class SmallGroupServiceImpl implements SmallGroupService {

    private final SmallGroupMapper smallGroupMapper;

    public SmallGroupServiceImpl(SmallGroupMapper smallGroupMapper) {
        this.smallGroupMapper = smallGroupMapper;
    }

    /**
     * 获取当前小组成员信息
     *
     * @return 小组成员列表
     */
    @Override
    public List<GroupStudentDataInfo> selectGroupList(GroupStudentDataInfo groupStudentDataInfo) {
        Integer manageGroup = smallGroupMapper.QueryGroup(groupStudentDataInfo.getUsername()).getManageGroup();
        groupStudentDataInfo.setGroupId(Long.valueOf(manageGroup));
        return smallGroupMapper.selectGroupList(groupStudentDataInfo);
    }
}
