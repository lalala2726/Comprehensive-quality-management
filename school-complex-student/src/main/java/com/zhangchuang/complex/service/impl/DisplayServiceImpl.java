package com.zhangchuang.complex.service.impl;

import com.zhangchuang.complex.entity.DisplayGroup;
import com.zhangchuang.complex.entity.StudentGrade;
import com.zhangchuang.complex.entity.StudentLastScore;
import com.zhangchuang.complex.mapper.DisplayMapper;
import com.zhangchuang.complex.mapper.LastScoreMapper;
import com.zhangchuang.complex.mapper.RatingsMapper;
import com.zhangchuang.complex.mapper.SmallGroupMapper;
import com.zhangchuang.complex.service.DisplayService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Zhangchuang
 * @create 2023/5/28 21:00
 */
@Service
public class DisplayServiceImpl implements DisplayService {

    private final DisplayMapper displayMapper;
    private final SmallGroupMapper smallGroupMapper;
    private final LastScoreMapper lastScoreMapper;

    private final RatingsMapper ratingsMapper;

    public DisplayServiceImpl(DisplayMapper displayMapper, SmallGroupMapper smallGroupMapper, LastScoreMapper lastScoreMapper, RatingsMapper ratingsMapper) {
        this.displayMapper = displayMapper;
        this.smallGroupMapper = smallGroupMapper;
        this.lastScoreMapper = lastScoreMapper;
        this.ratingsMapper = ratingsMapper;
    }

    /**
     * 通过ID展示小组的成绩信息
     *
     * @param id 小组ID
     * @return 成绩信息
     */
    @Override
    public DisplayGroup getGroupDataById(Integer id) {
        List<StudentGrade> list = displayMapper.getGroupDataById(id);
        List<String> name = new ArrayList<>();
        List<Integer> lastFraction = new ArrayList<>();
        List<Integer> thisFraction = new ArrayList<>();
        List<Integer> difference = new ArrayList<>();
        String groupName = null;
        for (StudentGrade grade : list) {
            Integer lastTotalScore = lastScoreMapper.queryLastTotalScore(grade.getStudentId());
            grade.setLastTimeResult(lastTotalScore);
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
            groupName = grade.getGroupName();
        }
        return new DisplayGroup(name, lastFraction, thisFraction, difference, groupName);
    }

    /**
     * 展示学生数据分析
     *
     * @return 数据
     */
    @Override
    public HashMap<String, Object> displayDashboardData() {
        HashMap<String, Object> result = new HashMap<>();
        Integer numberOfGroups = smallGroupMapper.queryNumberOfGroup();
        List<Integer> totalThisResultList = new ArrayList<>();
        List<Integer> totalLastTimeResultList = new ArrayList<>();
        List<String> groupNameList = new ArrayList<>();
        List<Integer> totalAbsList = new ArrayList<>();

        for (int i = 1; i < numberOfGroups + 1; i++) {
            List<StudentGrade> studentGrades = displayMapper.getGroupDataById(i);

            int totalThisResult = 0;
            int totalLastTimeResult = 0;
            String groupName = null;

            for (StudentGrade grade : studentGrades) {
                Integer lastTotalScore = lastScoreMapper.queryLastTotalScore(grade.getStudentId());
                grade.setLastTimeResult(lastTotalScore);
                // 计算总分
                int thisResult = grade.getSelf() + grade.getInformation() + grade.getCommunicate()
                        + grade.getTeam() + grade.getSolve() + grade.getInnovation();
                grade.setThisResult(thisResult);

                // 累加总分和上次总分
                totalThisResult += thisResult;
                totalLastTimeResult += grade.getLastTimeResult();

                // 获取组名
                groupName = grade.getGroupName();
            }

            // 计算差值
            int totalAbs = Math.abs(totalLastTimeResult - totalThisResult);

            // 存入List中
            totalThisResultList.add(totalThisResult);
            totalLastTimeResultList.add(totalLastTimeResult);
            groupNameList.add(groupName);
            totalAbsList.add(totalAbs);
        }

        // 存入HashMap中
        result.put("totalThisResult", totalThisResultList);
        result.put("totalLastTimeResult", totalLastTimeResultList);
        result.put("groupName", groupNameList);
        result.put("totalAbs", totalAbsList);

        return result;
    }


    /**
     * 获取指定学生的数据信息
     *
     * @param studentId 学生ID
     * @return 数据
     */
    @Override
    public HashMap<String, Object> getStudentDataById(String studentId) {
        HashMap<String, Object> map = new HashMap<>();

        // 一次性查询 lastScore 和 thisScore 的数据
        StudentLastScore lastScore = lastScoreMapper.getStudentDetailById(studentId);
        StudentGrade thisScore = ratingsMapper.getRatingInfoById(studentId);

        // 构建 lastScoreList 和 thisScoreList
        List<Integer> lastScoreList = Arrays.asList(
                lastScore.getSelf(), lastScore.getInformation(), lastScore.getCommunicate(),
                lastScore.getTeam(), lastScore.getSolve(), lastScore.getInnovation()
        );
        List<Integer> thisScoreList = Arrays.asList(
                thisScore.getSelf(), thisScore.getInformation(), thisScore.getCommunicate(),
                thisScore.getTeam(), thisScore.getSolve(), thisScore.getInnovation()
        );

        map.put("lastScore", lastScoreList);
        map.put("thisScore", thisScoreList);
        map.put("studentName", thisScore.getStudentName());

        return map;
    }


}
