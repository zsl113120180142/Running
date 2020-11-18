package com.running.bean;

import java.util.List;

public class GradeBean {
    private Integer gid;

    private Integer cid;

    private Integer gname;

    private Integer gdelete;

    private List<ClassesBean> classesBeanList;

    private CollegeBean collegeBean;

    public List<ClassesBean> getClassesBeanList() {
        return classesBeanList;
    }

    public void setClassesBeanList(List<ClassesBean> classesBeanList) {
        this.classesBeanList = classesBeanList;
    }

    public CollegeBean getCollegeBean() {
        return collegeBean;
    }

    public void setCollegeBean(CollegeBean collegeBean) {
        this.collegeBean = collegeBean;
    }

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
                ", classesBeanList=" + classesBeanList +
                ", collegeBean=" + collegeBean +
                '}';
    }
}