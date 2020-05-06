package com.running.bean;

public class AdminBean {
    private Integer aid;

    private String username;

    private String password;

    private String phone;

    private String apicture;

    private String aname;

    private String iden;

    private Integer works;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getApicture() {
        return apicture;
    }

    public void setApicture(String apicture) {
        this.apicture = apicture == null ? null : apicture.trim();
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname == null ? null : aname.trim();
    }

    public String getIden() {
        return iden;
    }

    public void setIden(String iden) {
        this.iden = iden == null ? null : iden.trim();
    }

    public Integer getWorks() {
        return works;
    }

    public void setWorks(Integer works) {
        this.works = works;
    }

    @Override
    public String toString() {
        return "AdminBean{" +
                "aid=" + aid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", apicture='" + apicture + '\'' +
                ", aname='" + aname + '\'' +
                ", iden='" + iden + '\'' +
                ", works=" + works +
                '}';
    }
}