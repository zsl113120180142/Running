package com.running.bean;

public class Regular {
    //rule
    private Integer uid;

    private Integer rweek;

    private String sex;

    private String rkm;

    private String rtime;

    private String starttime;

    private String endtime;

    //result
    private Integer rid;

    private Integer minresult;

    private Integer rresult;

    //semester
    private Integer seid;

    private String sename;

    //week
    private Integer wid;

    private String wname;

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
        this.sex = sex;
    }

    public String getRkm() {
        return rkm;
    }

    public void setRkm(String rkm) {
        this.rkm = rkm;
    }

    public String getRtime() {
        return rtime;
    }

    public void setRtime(String rtime) {
        this.rtime = rtime;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getMinresult() {
        return minresult;
    }

    public void setMinresult(Integer minresult) {
        this.minresult = minresult;
    }

    public Integer getRresult() {
        return rresult;
    }

    public void setRresult(Integer rresult) {
        this.rresult = rresult;
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
        this.sename = sename;
    }

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
        this.wname = wname;
    }

    @Override
    public String toString() {
        return "Regular{" +
                "uid=" + uid +
                ", rweek=" + rweek +
                ", sex='" + sex + '\'' +
                ", rkm='" + rkm + '\'' +
                ", rtime='" + rtime + '\'' +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", rid=" + rid +
                ", minresult=" + minresult +
                ", rresult=" + rresult +
                ", seid=" + seid +
                ", sename='" + sename + '\'' +
                ", wid=" + wid +
                ", wname='" + wname + '\'' +
                '}';
    }
}
