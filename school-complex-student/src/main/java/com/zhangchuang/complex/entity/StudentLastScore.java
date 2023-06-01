package com.zhangchuang.complex.entity;

/**
 * 学生上次分数详情
 *
 * @author Zhangchuang
 * @create 2023/6/1 13:27
 */
public class StudentLastScore {
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
     * 小组名称
     */
    private String groupName;

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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("StudentLastScoreDetail{");
        sb.append("ratingsId=").append(ratingsId);
        sb.append(", studentId='").append(studentId).append('\'');
        sb.append(", studentName='").append(studentName).append('\'');
        sb.append(", self=").append(self);
        sb.append(", information=").append(information);
        sb.append(", communicate=").append(communicate);
        sb.append(", team=").append(team);
        sb.append(", solve=").append(solve);
        sb.append(", innovation=").append(innovation);
        sb.append(", groupName='").append(groupName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

