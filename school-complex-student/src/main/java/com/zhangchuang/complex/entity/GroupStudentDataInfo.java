package com.zhangchuang.complex.entity;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @author Zhangchuang
 * @create 2023/5/23 15:13
 */
public class GroupStudentDataInfo extends BaseEntity {

    /**
     * ID
     */
    private Long userId;

    /**
     * 部门
     */
    private Long deptId;

    /**
     * 学号
     */
    private String userIC;

    /**
     * 学生姓名
     */
    private String userName;

    /**
     * 小组名称
     */
    private String groupName;

    /**
     * 小组ID
     */
    private String groupId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getUserIC() {
        return userIC;
    }

    public void setUserIC(String userIC) {
        this.userIC = userIC;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GroupStudentDataInfo{");
        sb.append("userId=").append(userId);
        sb.append(", deptId=").append(deptId);
        sb.append(", userIC='").append(userIC).append('\'');
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", groupName='").append(groupName).append('\'');
        sb.append(", groupId='").append(groupId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
