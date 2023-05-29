package com.zhangchuang.complex.service.impl;

import com.ruoyi.common.exception.ServiceException;
import com.zhangchuang.complex.entity.StudentGrade;
import com.zhangchuang.complex.mapper.RatingsMapper;
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
    private final RatingsMapper ratingsMapper;

    public SmallGroupServiceImpl(SmallGroupMapper smallGroupMapper, RatingsMapper ratingsMapper) {
        this.smallGroupMapper = smallGroupMapper;
        this.ratingsMapper = ratingsMapper;
    }

    /**
     * 获取当前小组成员信息
     *
     * @return 小组成员列表
     */
    @Override
    public List<StudentGrade> selectGroupList(StudentGrade studentGrade, String username) {
        Integer id = smallGroupMapper.QueryGroup(username).getManageGroup();
        if (id == null) {
            throw new ServiceException("您还没有管理小组");
        }
        List<StudentGrade> list = smallGroupMapper.selectGroupList(studentGrade, id);
        for (StudentGrade grade : list) {
            //计算总分
            Integer thisResult = grade.getSelf() + grade.getInformation() + grade.getCommunicate()
                    + grade.getTeam() + grade.getSolve() + grade.getInnovation();
            grade.setThisResult(thisResult);
            //计算差值
            Integer abs = Math.abs(grade.getLastTimeResult() - thisResult);
            grade.setDifference(abs);
            if ("0".equals(grade.getStatus())) {
                grade.setLastTimeResult(0);
                grade.setDifference(0);
            }

        }
        return list;
    }


    /**
     * 修改成绩信息
     *
     * @param studentGrade 参数
     * @return 返回修改结果
     */
    @Override
    public Integer updateRating(StudentGrade studentGrade) {

        return ratingsMapper.updateRating(studentGrade);
    }

    /**
     * 检查是否提交过信息
     *
     * @param username 学生学号
     * @return 返回结果
     */
    @Override
    public Integer checkStatus(String username) {
        return smallGroupMapper.checkStatus(username);
    }

}
