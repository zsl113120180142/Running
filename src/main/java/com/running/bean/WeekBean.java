package com.running.bean;

public class WeekBean {
    private Integer wid;

    private String wname;

    private Integer seid;

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname == null ? null : wname.trim();
    }

    public Integer getSeid() {
        return seid;
    }

    public void setSeid(Integer seid) {
        this.seid = seid;
    }

    @Override
    public String toString() {
        return "WeekBean{" +
                "wid=" + wid +
                ", wname='" + wname + '\'' +
                ", seid=" + seid +
                '}';
    }
}