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

    /**
     * 通过ID获取详细信息
     *
     * @param id 学生ID
     * @return 返回结果
     */
    @Override
    public StudentGrade getRatingInfoById(Long id) {
        StudentGrade result = ratingsMapper.getRatingInfoById(id);
        //计算本次成绩
        Integer thisResult = result.getSelf() + result.getInformation() + result.getCommunicate()
                + result.getTeam() + result.getSolve() + result.getInnovation();
        result.setThisResult(thisResult);
        //计算差值
        int abs = Math.abs(thisResult - result.getLastTimeResult());
        result.setDifference(abs);
        return result;
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
}
