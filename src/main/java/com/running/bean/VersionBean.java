package com.running.bean;

public class VersionBean {
    private Integer vid;

    private String version;

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    @Override
    public String toString() {
        return "VersionBean{" +
                "vid=" + vid +
                ", version='" + version + '\'' +
                '}';
    }
}