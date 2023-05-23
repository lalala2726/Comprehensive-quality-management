package com.zhangchuang.complex.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * @author Zhangchuang
 * @create 2023/5/22 23:14
 */
public class StudentGroup extends BaseEntity {

    /**
     * 小组ID
     */
    private Integer groupId;

    /**
     * 小组名称
     */
    private String groupName;

    /**
     * 提交状态
     */
    private String status;

    /**
     * 备足
     */
    private String remark;

    /**
     * 提交时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date submitTime;


    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("StudentGroup{");
        sb.append("groupId=").append(groupId);
        sb.append(", groupName='").append(groupName).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", remark='").append(remark).append('\'');
        sb.append(", submitTime=").append(submitTime);
        sb.append('}');
        return sb.toString();
    }
}
