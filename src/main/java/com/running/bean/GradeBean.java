package com.running.bean;

public class GradeBean {
    private Integer gid;

    private Integer cid;

    private Integer gname;

    private Integer gdelete;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getGname() {
        return gname;
    }

    public void setGname(Integer gname) {
        this.gname = gname;
    }

    public Integer getGdelete() {
        return gdelete;
    }

    public void setGdelete(Integer gdelete) {
        this.gdelete = gdelete;
    }

    @Override
    public String toString() {
        return "GradeBean{" +
                "gid=" + gid +
                ", cid=" + cid +
                ", gname=" + gname +
                ", gdelete=" + gdelete +
                '}';
    }
}