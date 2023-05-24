package com.zhangchuang.complex.entity;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @author Zhangchuang
 * @create 2023/5/23 15:13
 */
public class GroupStudentDataInfo extends BaseEntity {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 部门
     */
    private Long deptId;

    /**
     * 用户账号
     */
    private String username;

    /**
     * 学生姓名
     */
    private String nickName;

    /**
     * 小组名称
     */
    private String groupName;

    /**
     * 小组ID
     */
    private Long groupId;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GroupStudentDataInfo{");
        sb.append("userId=").append(userId);
        sb.append(", deptId=").append(deptId);
        sb.append(", username='").append(username).append('\'');
        sb.append(", nickName='").append(nickName).append('\'');
        sb.append(", groupName='").append(groupName).append('\'');
        sb.append(", groupId=").append(groupId);
        sb.append('}');
        return sb.toString();
    }
}
