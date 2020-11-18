package com.running.bean;

public class RuleBean {
    private Integer uid;

    private Integer rweek;

    private String sex;

    private String rkm;

    private String rtime;

    private String starttime;

    private String endtime;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRweek() {
        return rweek;
    }

    public void setRweek(Integer rweek) {
        this.rweek = rweek;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getRkm() {
        return rkm;
    }

    public void setRkm(String rkm) {
        this.rkm = rkm == null ? null : rkm.trim();
    }

    public String getRtime() {
        return rtime;
    }

    public void setRtime(String rtime) {
        this.rtime = rtime == null ? null : rtime.trim();
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime == null ? null : starttime.trim();
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    @Override
    public String toString() {
        return "RuleBean{" +
                "uid=" + uid +
                ", rweek=" + rweek +
                ", sex='" + sex + '\'' +
                ", rkm='" + rkm + '\'' +
                ", rtime='" + rtime + '\'' +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                '}';
    }
}