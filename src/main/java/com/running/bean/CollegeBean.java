package com.running.bean;

public class CollegeBean {
    private Integer cid;

    private String cname;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    @Override
    public String toString() {
        return "CollegeBean{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }
}