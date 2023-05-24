package com.zhangchuang.complex.entity;

import com.ruoyi.common.core.domain.BaseEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

    /**
     * 提交状态
     */
    private String status;

    public Long getRatingsId() {
        return ratingsId;
    }


    public void setRatingsId(Long ratingsId) {
        this.ratingsId = ratingsId;
    }

    @NotBlank(message = "学生学号不能为空")
    @Size(min = 0, max = 30, message = "学生学号长度不能超过30个字符")
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @NotBlank(message = "学生姓名不能为空")
    @Size(min = 0, max = 30, message = "学生姓名长度不能超过30个字符")
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @NotBlank(message = "分数不能为空！")
    @Max(value = 2, message = "分数限制为2")
    @Min(value = 0, message = "不能低于0")
    public Integer getSelf() {
        return self;
    }

    public void setSelf(Integer self) {
        this.self = self;
    }

    @NotBlank(message = "分数不能为空！")
    @Max(value = 2, message = "分数限制为2")
    @Min(value = 0, message = "不能低于0")
    public Integer getInformation() {
        return information;
    }

    public void setInformation(Integer information) {
        this.information = information;
    }

    @NotBlank(message = "分数不能为空！")
    @Max(value = 2, message = "分数限制为2")
    @Min(value = 0, message = "不能低于0")
    public Integer getCommunicate() {
        return communicate;
    }

    public void setCommunicate(Integer communicate) {
        this.communicate = communicate;
    }

    @NotBlank(message = "分数不能为空！")
    @Max(value = 2, message = "分数限制为2")
    @Min(value = 0, message = "不能低于0")
    public Integer getTeam() {
        return team;
    }

    public void setTeam(Integer team) {
        this.team = team;
    }

    @NotBlank(message = "分数不能为空！")
    @Max(value = 2, message = "分数限制为2")
    @Min(value = 0, message = "不能低于0")
    public Integer getSolve() {
        return solve;
    }

    public void setSolve(Integer solve) {
        this.solve = solve;
    }

    @NotBlank(message = "分数不能为空！")
    @Max(value = 2, message = "分数限制为2")
    @Min(value = 0, message = "不能低于0")
    public Integer getInnovation() {
        return innovation;
    }

    public void setInnovation(Integer innovation) {
        this.innovation = innovation;
    }

    @NotBlank(message = "上次总分不能为空")
    @Max(value = 10, message = "不能超过10")
    @Min(value = 0, message = "不能低于0")
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        sb.append(", status='").append(status).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
