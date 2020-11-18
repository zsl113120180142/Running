package com.running.bean;

import java.util.List;

public class SemesterBean {
    private Integer seid;

    private String sename;

    private List<WeekBean> weekBeanList;

    public List<WeekBean> getWeekBeanList() {
        return weekBeanList;
    }

    public void setWeekBeanList(List<WeekBean> weekBeanList) {
        this.weekBeanList = weekBeanList;
    }

    public Integer getSeid() {
        return seid;
    }

    public void setSeid(Integer seid) {
        this.seid = seid;
    }

    public String getSename() {
        return sename;
    }

    public void setSename(String sename) {
        this.sename = sename == null ? null : sename.trim();
    }

    @Override
    public String toString() {
        return "SemesterBean{" +
                "seid=" + seid +
                ", sename='" + sename + '\'' +
                ", weekBeanList=" + weekBeanList +
                '}';
    }
}