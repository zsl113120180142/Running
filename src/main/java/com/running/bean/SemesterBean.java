package com.running.bean;

public class SemesterBean {
    private Integer seid;

    private String sename;

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
                '}';
    }
}