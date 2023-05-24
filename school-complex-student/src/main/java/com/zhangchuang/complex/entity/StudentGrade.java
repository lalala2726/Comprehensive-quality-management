package com.zhangchuang.complex.entity;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生成绩表
 *
 * @author Zhangchuang
 * @create 2023/5/24 15:59
 */
public class StudentGrade extends BaseEntity {

    /**
     * 成绩表ID
     */
    private Long ratingsId;

    /**
     * 学生学号
     */
    private String studentId;
    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 自我学习
     */
    private Integer self;

    /**
     * 信息处理
     */
    private Integer information;

    /**
     * 沟通交流
     */
    private Integer communicate;

    /**
     * 团队合作
     */
    private Integer team;

    /**
     * 解决问题
     */
    private Integer solve;

    /**
     * 革新创新
     */
    private Integer innovation;


    /**
     * 上次总分
     */
    private Integer lastTimeResult;


    /**
     * 本次总分
     */
    private Integer thisResult;


    /**
     * 差值
     */
    private Integer difference;


    public Long getRatingsId() {
        return ratingsId;
    }

    public void setRatingsId(Long ratingsId) {
        this.ratingsId = ratingsId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getSelf() {
        return self;
    }

    public void setSelf(Integer self) {
        this.self = self;
    }

    public Integer getInformation() {
        return information;
    }

    public void setInformation(Integer information) {
        this.information = information;
    }

    public Integer getCommunicate() {
        return communicate;
    }

    public void setCommunicate(Integer communicate) {
        this.communicate = communicate;
    }

    public Integer getTeam() {
        return team;
    }

    public void setTeam(Integer team) {
        this.team = team;
    }

    public Integer getSolve() {
        return solve;
    }

    public void setSolve(Integer solve) {
        this.solve = solve;
    }

    public Integer getInnovation() {
        return innovation;
    }

    public void setInnovation(Integer innovation) {
        this.innovation = innovation;
    }

    public Integer getLastTimeResult() {
        return lastTimeResult;
    }

    public void setLastTimeResult(Integer lastTimeResult) {
        this.lastTimeResult = lastTimeResult;
    }

    public Integer getThisResult() {
        return thisResult;
    }

    public void setThisResult(Integer thisResult) {
        this.thisResult = thisResult;
    }

    public Integer getDifference() {
        return difference;
    }

    public void setDifference(Integer difference) {
        this.difference = difference;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("StudentGrade{");
        sb.append("ratingsId=").append(ratingsId);
        sb.append(", studentId='").append(studentId).append('\'');
        sb.append(", studentName='").append(studentName).append('\'');
        sb.append(", self=").append(self);
        sb.append(", information=").append(information);
        sb.append(", communicate=").append(communicate);
        sb.append(", team=").append(team);
        sb.append(", solve=").append(solve);
        sb.append(", innovation=").append(innovation);
        sb.append(", lastTimeResult=").append(lastTimeResult);
        sb.append(", thisResult=").append(thisResult);
        sb.append(", difference=").append(difference);
        sb.append('}');
        return sb.toString();
    }
}
