package com.zhangchuang.complex.service.impl;

import com.zhangchuang.complex.entity.StudentGrade;
import com.zhangchuang.complex.mapper.DisplayGroup;
import com.zhangchuang.complex.mapper.DisplayMapper;
import com.zhangchuang.complex.service.DisplayService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhangchuang
 * @create 2023/5/28 21:00
 */
@Service
public class DisplayServiceImpl implements DisplayService {

    private final DisplayMapper displayMapper;

    public DisplayServiceImpl(DisplayMapper displayMapper) {
        this.displayMapper = displayMapper;
    }

    @Override
    public DisplayGroup getGroupDataById(Integer id) {
        List<StudentGrade> list = displayMapper.getGroupDataById(id);
        List<String> name = new ArrayList<>();
        List<Integer> lastFraction = new ArrayList<>();
        List<Integer> thisFraction = new ArrayList<>();
        List<Integer> difference = new ArrayList<>();
        for (StudentGrade grade : list) {

            //计算总分
            Integer thisResult = grade.getSelf() + grade.getInformation() + grade.getCommunicate()
                    + grade.getTeam() + grade.getSolve() + grade.getInnovation();
            grade.setThisResult(thisResult);
            //计算差值
            Integer abs = Math.abs(grade.getLastTimeResult() - thisResult);
            grade.setDifference(abs);
            //将数据存放在集合中
            name.add(grade.getStudentName());
            lastFraction.add(grade.getLastTimeResult());
            thisFraction.add(thisResult);
            difference.add(abs);
        }
        return new DisplayGroup(name, lastFraction, thisFraction, difference);
    }
}
