package com.zhangchuang.complex.entity;

/**
 * 小组关系确定表
 *
 * @author Zhangchuang
 * @create 2023/5/25 21:47
 */
public class GroupManage {


    /**
     * 小组编号
     */
    private Long groupId;

    /**
     * 学生账号
     */
    private String studentId;

    /**
     * 小组表
     */
    private Integer manageGroup;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Integer getManageGroup() {
        return manageGroup;
    }

    public void setManageGroup(Integer manageGroup) {
        this.manageGroup = manageGroup;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GroupManage{");
        sb.append("groupId=").append(groupId);
        sb.append(", studentId='").append(studentId).append('\'');
        sb.append(", manageGroup=").append(manageGroup);
        sb.append('}');
        return sb.toString();
    }
}
