package com.zhangchuang.complex.service.impl;

import com.ruoyi.common.exception.ServiceException;
import com.zhangchuang.complex.entity.GroupStudentDataInfo;
import com.zhangchuang.complex.entity.StudentGrade;
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
    public List<StudentGrade> selectGroupList(StudentGrade studentGrade, String username) {
        System.out.println("username = " + username);
        Integer id = smallGroupMapper.QueryGroup(username).getManageGroup();
        System.out.println("小组ID" + id);
        if (id == null) {
            throw new ServiceException("您还没有管理小组");
        }
        return smallGroupMapper.selectGroupList(studentGrade, id);
    }

}
