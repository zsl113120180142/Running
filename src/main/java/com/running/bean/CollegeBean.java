package com.running.bean;

import java.util.List;

public class CollegeBean {
    private Integer cid;

    private String cname;

    private List<GradeBean> gradeBeanList;

    public List<GradeBean> getGradeBeanList() {
        return gradeBeanList;
    }

    public void setGradeBeanList(List<GradeBean> gradeBeanList) {
        this.gradeBeanList = gradeBeanList;
    }

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
                ", gradeBeanList=" + gradeBeanList +
                '}';
    }
}