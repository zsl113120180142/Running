package com.running.service;

import com.running.bean.*;
import com.running.dao.*;
import com.running.method.StringCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: AutomationService
 * @Description: 自动运行的类
 * @Author: zsl
 * @Date: 2020/8/25 20:17
 * @Version: v1.0
 */
@Service
public class AutomationService {
    @Autowired
    WeekBeanMapper weekBeanMapper;
    @Autowired
    StringCheck stringCheck;
    @Autowired
    StudentBeanMapper studentBeanMapper;
    @Autowired
    ClassesBeanMapper classesBeanMapper;
    @Autowired
    GradeBeanMapper gradeBeanMapper;
    @Autowired
    CollegeBeanMapper collegeBeanMapper;
    @Autowired
    StatisticBeanMapper statisticBeanMapper;
    @Autowired
    ResultBeanMapper resultBeanMapper;

    /**
     * 生成下一周
     */
    public Boolean AutomationIncreaseWeek() {
        //获取当前周次
        WeekBeanExample weekBeanExample = new WeekBeanExample();
        weekBeanExample.setOrderByClause("wid DESC");
        List<WeekBean> weekBeanList = weekBeanMapper.selectByExample(weekBeanExample);
        String nowwname = weekBeanList.get(0).getWname();
        Integer i = stringCheck.transformStringToInteger(nowwname);
        i += 1;
        String nextwname = String.valueOf(i) ;
        WeekBean weekBean = new WeekBean();
        weekBean.setWname(nextwname);
        weekBean.setSeid(weekBeanList.get(0).getSeid());
        int e = weekBeanMapper.insertSelective(weekBean);
        return true;
    }
    /**
     * 生成一周的记录
     */
    public Boolean AutomationIncreaseStatistic(){
        //获取当前周次
        WeekBeanExample weekBeanExample = new WeekBeanExample();
        weekBeanExample.setOrderByClause("wid DESC");
        List<WeekBean> weekBeanList = weekBeanMapper.selectByExample(weekBeanExample);
        //获取全部学生
        List<StudentBean> studentBeanList = studentBeanMapper.selectByExample(null);
        for (int i =0 ; i<studentBeanList.size();i++){
            StudentBean studentBean = studentBeanList.get(i);
            ClassesBean classesBean = classesBeanMapper.selectByPrimaryKey(studentBean.getClid());
            GradeBean gradeBean = gradeBeanMapper.selectByPrimaryKey(classesBean.getGid());
            CollegeBean collegeBean = collegeBeanMapper.selectByPrimaryKey(gradeBean.getCid());
            StatisticBean statisticBean = new StatisticBean();
            statisticBean.setSid(studentBean.getSid());
            statisticBean.setStnt(0);
            statisticBean.setWid(weekBeanList.get(0).getWid());
            statisticBean.setCid(collegeBean.getCid());
            statisticBean.setGid(gradeBean.getGid());
            statisticBean.setClid(classesBean.getClid());
            statisticBean.setSttime(new Date());
            statisticBeanMapper.insertSelective(statisticBean);
        }
        return true;
    }

    public Boolean AutomationUpdateSnt(){
        //获取全部学生
        List<StudentBean> studentBeanList = studentBeanMapper.selectByExample(null);
        //获取当前周次
        WeekBeanExample weekBeanExample = new WeekBeanExample();
        weekBeanExample.setOrderByClause("wid DESC");
        List<WeekBean> weekBeanList = weekBeanMapper.selectByExample(weekBeanExample);
        Integer wid =weekBeanList.get(0).getWid();
        for (StudentBean studentBean : studentBeanList){
            Integer sid = studentBean.getSid();

            StatisticBeanExample statisticBeanExample = new StatisticBeanExample();
            statisticBeanExample.setOrderByClause("stid DESC");
            StatisticBeanExample.Criteria statisticBeanExampleCriteria = statisticBeanExample.createCriteria();
            statisticBeanExampleCriteria.andWidEqualTo(wid);
            statisticBeanExampleCriteria.andSidEqualTo(sid);
            List<StatisticBean> statisticBeanList = statisticBeanMapper.selectByExample(statisticBeanExample);
            Integer stnt = statisticBeanList.get(0).getStnt();
            Integer snt = studentBean.getSnt()+stnt;
            studentBean.setSnt(snt);
            studentBeanMapper.updateByPrimaryKeySelective(studentBean);
        }
        return true;
    }

    public Boolean AutomationUpdatesrun(){
        //获取全部学生
        List<StudentBean> studentBeanList = studentBeanMapper.selectByExample(null);
        //获取全部规则
        ResultBeanExample example =new ResultBeanExample();
        example.setOrderByClause("minresult ASC");
        List<ResultBean> resultBeanList = resultBeanMapper.selectByExample(example);
        for (StudentBean studentBean :studentBeanList){

            for (int i = 0 ;i<resultBeanList.size();i++){
                if (studentBean.getSnt()==null){
                    studentBean.setSnt(1);
                }
                if (studentBean.getSnt()>=resultBeanList.get(i).getMinresult() && studentBean.getSnt()<=resultBeanList.get(i+1).getMinresult()&&i+1<=resultBeanList.size()){
                    studentBean.setSrun(resultBeanList.get(i).getRresult());
                    studentBeanMapper.updateByPrimaryKeySelective(studentBean);
                    break;
                }else if (studentBean.getSnt()>=resultBeanList.get(i).getMinresult() &&i+1>=resultBeanList.size()){
                    studentBean.setSrun(resultBeanList.get(i).getRresult());
                    studentBeanMapper.updateByPrimaryKeySelective(studentBean);
                    break;
                }

            }
        }
        return true;
    }

}
