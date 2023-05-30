package com.zhangchuang.complex.entity;

import java.util.List;

/**
 * @author Zhangchuang
 * @create 2023/5/28 21:19
 */
public class DisplayGroup {
    /**
     * 姓名
     */
    private List<String> name;

    /**
     * 上次总分
     */
    private List<Integer> lastFraction;

    /**
     * 本次总分
     */
    private List<Integer> thisFraction;

    /**
     * 差值
     */
    private List<Integer> difference;

    /**
     * 所在小组
     */
    private String groupName;

    public DisplayGroup(List<String> name, List<Integer> lastFraction, List<Integer> thisFraction, List<Integer> difference, String groupName) {
        this.name = name;
        this.lastFraction = lastFraction;
        this.thisFraction = thisFraction;
        this.difference = difference;
        this.groupName = groupName;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public List<Integer> getLastFraction() {
        return lastFraction;
    }

    public void setLastFraction(List<Integer> lastFraction) {
        this.lastFraction = lastFraction;
    }

    public List<Integer> getThisFraction() {
        return thisFraction;
    }

    public void setThisFraction(List<Integer> thisFraction) {
        this.thisFraction = thisFraction;
    }

    public List<Integer> getDifference() {
        return difference;
    }

    public void setDifference(List<Integer> difference) {
        this.difference = difference;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DisplayGroup{");
        sb.append("name=").append(name);
        sb.append(", lastFraction=").append(lastFraction);
        sb.append(", thisFraction=").append(thisFraction);
        sb.append(", difference=").append(difference);
        sb.append(", groupName='").append(groupName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
