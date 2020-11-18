package com.running.service;

import com.running.bean.*;
import com.running.dao.ResultBeanMapper;
import com.running.dao.RuleBeanMapper;
import com.running.dao.SemesterBeanMapper;
import com.running.dao.WeekBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理后台页面请求
 */
@Service
public class RuleService {

    @Autowired
    SemesterBeanMapper semesterBeanMapper;
    @Autowired
    WeekBeanMapper weekBeanMapper;
    @Autowired
    ResultBeanMapper resultBeanMapper;
    @Autowired
    RuleBeanMapper ruleBeanMapper;


    /**
     * 新增学期
     *
     * @param semesterBean
     */
    public void addSem(SemesterBean semesterBean) {
        semesterBeanMapper.insertSelective(semesterBean);
    }

    /**
     * 显示学期信息
     *
     * @return
     */
    public List<SemesterBean> Semester() {
        return semesterBeanMapper.selectByExample(null);
    }

    /**
     * 新增学期信息
     *
     * @param weekBean
     */
    public void addWeek(WeekBean weekBean) {
            weekBeanMapper.insertSelective(weekBean);

    }


    public List<ResultBean> getAllResult() {
        return resultBeanMapper.selectByExample(null);
    }


    public void upateResult(ResultBean resultBean) {
        resultBeanMapper.updateByPrimaryKeySelective(resultBean);
    }

    public List<RuleBean> getAllRule() {
        RuleBean boyRule = getRuleBySex("男").get(0);
        RuleBean grilRule = getRuleBySex("女").get(0);
        List<RuleBean> allRule = new ArrayList<>();
        allRule.add(boyRule);
        allRule.add(grilRule);
        return  allRule;
    }

    public List<RuleBean> getRuleBySex(String sex){
        RuleBeanExample example = new RuleBeanExample();
        RuleBeanExample.Criteria criteria = example.createCriteria();
        criteria.andSexEqualTo(sex);
        return ruleBeanMapper.selectByExample(example);
    }

    public void upateRule(List<RuleBean> ruleBeanList) {
        for (RuleBean ruleBean : ruleBeanList) {
            if (ruleBean.getSex().equals("男")) {
                List<RuleBean> boyRule = getRuleBySex(ruleBean.getSex());
                for (RuleBean ruleBean1 : boyRule) {
                    ruleBean1.setRkm(ruleBean.getRkm());
                    ruleBean1.setRweek(ruleBean.getRweek());
                    ruleBeanMapper.updateByPrimaryKeySelective(ruleBean1);
                }
            } else {
                List<RuleBean> grilRule = getRuleBySex(ruleBean.getSex());
                for (RuleBean ruleBean1 : grilRule) {
                    ruleBean1.setRkm(ruleBean.getRkm());
                    ruleBean1.setRweek(ruleBean.getRweek());
                    ruleBeanMapper.updateByPrimaryKeySelective(ruleBean1);
                }
            }
        }
    }

    public Msg NowSemesterAndWeek() {
        //获取当前周次
        WeekBeanExample weekBeanExample = new WeekBeanExample();
        weekBeanExample.setOrderByClause("wid DESC");
        List<WeekBean> weekBeanList = weekBeanMapper.selectByExample(weekBeanExample);
        WeekBean weekBean = weekBeanList.get(0);
        //获取当前学期
        SemesterBeanExample semesterBeanExample = new SemesterBeanExample();
        semesterBeanExample.setOrderByClause("seid DESC");
        List<SemesterBean> semesterBeans = semesterBeanMapper.selectByExample(semesterBeanExample);
        SemesterBean semesterBean = semesterBeans.get(0);
        return Msg.success().add("weekBean",weekBean).add("semesterBean",semesterBean);
    }
}
