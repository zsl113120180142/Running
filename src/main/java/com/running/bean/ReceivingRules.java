package com.running.bean;

import java.util.List;

/**
 * @ClassName: ReceivingRules
 * @Description: 接收规则信息
 * @Author: zsl
 * @Date: 2020/8/27 15:52
 * @Version: v1.0
 */
public class ReceivingRules {
    private SemesterBean semesterBean;

    private WeekBean weekBean;

    private List<ResultBean> resultBeanList;

    private List<RuleBean> ruleBeanList;

    public SemesterBean getSemesterBean() {
        return semesterBean;
    }

    public void setSemesterBean(SemesterBean semesterBean) {
        this.semesterBean = semesterBean;
    }

    public WeekBean getWeekBean() {
        return weekBean;
    }

    public void setWeekBean(WeekBean weekBean) {
        this.weekBean = weekBean;
    }

    public List<ResultBean> getResultBeanList() {
        return resultBeanList;
    }

    public void setResultBeanList(List<ResultBean> resultBeanList) {
        this.resultBeanList = resultBeanList;
    }

    public List<RuleBean> getRuleBeanList() {
        return ruleBeanList;
    }

    public void setRuleBeanList(List<RuleBean> ruleBeanList) {
        this.ruleBeanList = ruleBeanList;
    }

    @Override
    public String toString() {
        return "ReceivingRules{" +
                "semesterBean=" + semesterBean +
                ", weekBean=" + weekBean +
                ", resultBeanList=" + resultBeanList +
                ", ruleBeanList=" + ruleBeanList +
                '}';
    }
}
