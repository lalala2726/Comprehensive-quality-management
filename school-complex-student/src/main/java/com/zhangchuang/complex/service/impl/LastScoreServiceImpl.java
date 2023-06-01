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
        return lastScoreMapper.selectStudentLastScoreList(studentLastScore);
    }
}
