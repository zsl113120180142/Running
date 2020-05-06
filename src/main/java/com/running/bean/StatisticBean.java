package com.running.bean;

public class StatisticBean {
    private Integer stid;

    private Integer sid;

    private Integer stnt;

    private Integer wid;

    private StudentBean studentBean;

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

    @Override
    public String toString() {
        return "StatisticBean{" +
                "stid=" + stid +
                ", sid=" + sid +
                ", stnt=" + stnt +
                ", wid=" + wid +
                ", " + studentBean +
                '}';
    }
}