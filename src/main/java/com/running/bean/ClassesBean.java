package com.running.bean;

public class ClassesBean {
    private Integer clid;

    private String clname;

    private Integer gid;

    private Integer cldelete;

    public Integer getClid() {
        return clid;
    }

    public void setClid(Integer clid) {
        this.clid = clid;
    }

    public String getClname() {
        return clname;
    }

    public void setClname(String clname) {
        this.clname = clname == null ? null : clname.trim();
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getCldelete() {
        return cldelete;
    }

    public void setCldelete(Integer cldelete) {
        this.cldelete = cldelete;
    }

    @Override
    public String toString() {
        return "ClassesBean{" +
                "clid=" + clid +
                ", clname='" + clname + '\'' +
                ", gid=" + gid +
                ", cldelete=" + cldelete +
                '}';
    }
}