package com.zhangchuang.complex.service.impl;

import com.ruoyi.common.exception.ServiceException;
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
        System.out.println("被修改的成绩信息: = " + studentGrade);
        return ratingsMapper.updateRating(studentGrade);
    }

    /**
     * 检查是否存在学生信息
     *
     * @param id studentId 学生ID
     * @return 返回检查结果
     */
    @Override
    public Integer checkStudentExist(String id) {
        return ratingsMapper.checkStudentExist(id);
    }


    /**
     * 添加学生成绩信息
     *
     * @param studentGrade 参数
     * @return 返回添加结果
     */
    @Override
    public Integer addStudentRating(StudentGrade studentGrade) {
        return ratingsMapper.addStudentRating(studentGrade);
    }


    /**
     * 检查学生包是是否包含学生成绩
     *
     * @param id 学生id
     * @return 结果
     */
    @Override
    public Integer checkRatingExist(String id) {
        return ratingsMapper.checkRatingExist(id);
    }

    /**
     * 删除学生成绩信息
     *
     * @param id 学号
     */
    @Override
    public void delete(String[] id) {
        for (String s : id) {
            Integer delete = ratingsMapper.delete(s);
            if (delete < 0) {
                throw new ServiceException("学号为" + s + "删除失败！");
            }
        }
    }
}
