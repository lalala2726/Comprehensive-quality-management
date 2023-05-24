package com.zhangchuang.complex.service.impl;

import com.zhangchuang.complex.entity.StudentGrade;
import com.zhangchuang.complex.mapper.RatingsMapper;
import com.zhangchuang.complex.service.RatingsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zhangchuang
 * @create 2023/5/24 17:40
 */
@Service
public class RatingsServiceImpl implements RatingsService {

    private final RatingsMapper ratingsMapper;

    public RatingsServiceImpl(RatingsMapper ratingsMapper) {
        this.ratingsMapper = ratingsMapper;
    }

    /**
     * 查询学生成绩列表
     *
     * @param studentGrade 参数
     * @return 成绩列表
     */
    @Override
    public List<StudentGrade> selectRatingsList(StudentGrade studentGrade) {
        List<StudentGrade> list = ratingsMapper.selectRatingList(studentGrade);
        for (StudentGrade grade : list) {
            //计算总分
            Integer thisResult = grade.getSelf() + grade.getInformation() + grade.getCommunicate()
                    + grade.getTeam() + grade.getSolve() + grade.getInnovation();
            grade.setThisResult(thisResult);
            //计算差值
            Integer abs = Math.abs(grade.getLastTimeResult() - thisResult);
            grade.setDifference(abs);
        }
        return list;

    }
}
