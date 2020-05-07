package com.running.bean;

public class StudentBean {
    private Integer sid;

    private String sname;

    private Integer clid;

    private String sex;

    private String snum;

    private Integer inclass;

    private Integer spe;

    private Integer srun;

    private Integer sresult;

    private String spicture;

    private String spassword;

    private Integer snt;

    private Integer sdelete;

    private ClassesBean classesBean;

    public ClassesBean getClassesBean() {
        return classesBean;
    }

    public void setClassesBean(ClassesBean classesBean) {
        this.classesBean = classesBean;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public Integer getClid() {
        return clid;
    }

    public void setClid(Integer clid) {
        this.clid = clid;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getSnum() {
        return snum;
    }

    public void setSnum(String snum) {
        this.snum = snum == null ? null : snum.trim();
    }

    public Integer getInclass() {
        return inclass;
    }

    public void setInclass(Integer inclass) {
        this.inclass = inclass;
    }

    public Integer getSpe() {
        return spe;
    }

    public void setSpe(Integer spe) {
        this.spe = spe;
    }

    public Integer getSrun() {
        return srun;
    }

    public void setSrun(Integer srun) {
        this.srun = srun;
    }

    public Integer getSresult() {
        return sresult;
    }

    public void setSresult(Integer sresult) {
        this.sresult = sresult;
    }

    public String getSpicture() {
        return spicture;
    }

    public void setSpicture(String spicture) {
        this.spicture = spicture == null ? null : spicture.trim();
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword == null ? null : spassword.trim();
    }

    public Integer getSnt() {
        return snt;
    }

    public void setSnt(Integer snt) {
        this.snt = snt;
    }

    public Integer getSdelete() {
        return sdelete;
    }

    public void setSdelete(Integer sdelete) {
        this.sdelete = sdelete;
    }

    @Override
    public String toString() {
        return "StudentBean{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", clid=" + clid +
                ", sex='" + sex + '\'' +
                ", snum='" + snum + '\'' +
                ", inclass=" + inclass +
                ", spe=" + spe +
                ", srun=" + srun +
                ", sresult=" + sresult +
                ", spicture='" + spicture + '\'' +
                ", spassword='" + spassword + '\'' +
                ", snt=" + snt +
                ", sdelete=" + sdelete +
                ", classesBean=" + classesBean +
                '}';
    }
}