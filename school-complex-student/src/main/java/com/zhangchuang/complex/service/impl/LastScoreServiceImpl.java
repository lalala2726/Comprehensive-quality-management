package com.zhangchuang.complex.service.impl;

import com.zhangchuang.complex.entity.StudentLastScore;
import com.zhangchuang.complex.mapper.LastScoreMapper;
import com.zhangchuang.complex.service.LastScoreService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zhangchuang
 * @create 2023/6/1 13:44
 */
@Service
public class LastScoreServiceImpl implements LastScoreService {

    private final LastScoreMapper lastScoreMapper;

    public LastScoreServiceImpl(LastScoreMapper lastScoreMapper) {
        this.lastScoreMapper = lastScoreMapper;
    }

    /**
     * 获取学生上次成绩列表
     *
     * @param studentLastScore 参数
     * @return 返回列表信息
     */
    @Override
    public List<StudentLastScore> selectStudentLastScoreList(StudentLastScore studentLastScore) {
        List<StudentLastScore> list = lastScoreMapper.selectStudentLastScoreList(studentLastScore);
        for (StudentLastScore grade : list) {
            //计算总分
            Integer thisResult = grade.getSelf() + grade.getInformation() + grade.getCommunicate()
                    + grade.getTeam() + grade.getSolve() + grade.getInnovation();
            grade.setThisResult(thisResult);
            grade.setThisResult(thisResult);
        }
        return list;
    }

    /**
     * 根据ID查询学神成绩信息
     *
     * @param id 学生ID
     * @return 成绩信息
     */
    @Override
    public StudentLastScore getStudentDetailById(String id) {
        StudentLastScore grade = lastScoreMapper.getStudentDetailById(id);
        //计算总分
        Integer thisResult = grade.getSelf() + grade.getInformation() + grade.getCommunicate()
                + grade.getTeam() + grade.getSolve() + grade.getInnovation();
        grade.setThisResult(thisResult);
        grade.setThisResult(thisResult);
        return grade;
    }

    /**
     * 修改成绩信息
     *
     * @param studentLastScore 参数
     * @return 修改结果
     */
    @Override
    public Integer updateStudentScore(StudentLastScore studentLastScore) {
        return lastScoreMapper.updateStudentScore(studentLastScore);
    }
}
