package com.running.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class StatisticBean {
    private Integer stid;

    private Integer sid;

    private Integer stnt;

    private Integer wid;

    private String mileage;

    private String runtime;

    //要接收日期格式的json数据
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date sttime;

    private Integer cid;

    private Integer gid;

    private Integer clid;

    private String weekDays;

    private StudentBean studentBean;

    public String getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(String weekDays) {
        this.weekDays = weekDays;
    }

    public StudentBean getStudentBean() {
        return studentBean;
    }

    public void setStudentBean(StudentBean studentBean) {
        this.studentBean = studentBean;
    }

    public Integer getStid() {
        return stid;
    }

    public void setStid(Integer stid) {
        this.stid = stid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getStnt() {
        return stnt;
    }

    public void setStnt(Integer stnt) {
        this.stnt = stnt;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage == null ? null : mileage.trim();
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime == null ? null : runtime.trim();
    }

    public Date getSttime() {
        return sttime;
    }

    public void setSttime(Date sttime) {
        this.sttime = sttime;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getClid() {
        return clid;
    }

    public void setClid(Integer clid) {
        this.clid = clid;
    }

    @Override
    public String toString() {
        return "StatisticBean{" +
                "stid=" + stid +
                ", sid=" + sid +
                ", stnt=" + stnt +
                ", wid=" + wid +
                ", mileage='" + mileage + '\'' +
                ", runtime='" + runtime + '\'' +
                ", sttime=" + sttime +
                ", cid=" + cid +
                ", gid=" + gid +
                ", clid=" + clid +
                ", weekDays='" + weekDays + '\'' +
                ", studentBean=" + studentBean +
                '}';
    }
}