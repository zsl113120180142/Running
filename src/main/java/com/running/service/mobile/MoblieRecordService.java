package com.running.service.mobile;

import com.running.bean.*;
import com.running.dao.*;
import com.running.method.StringCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: MoblieRecordService
 * @Description: TODO
 * @Author: zsl
 * @Date: 2020/8/26 15:30
 * @Version: v1.0
 */
@Service
public class MoblieRecordService {
    @Autowired
    StudentBeanMapper studentBeanMapper;
    @Autowired
    ResultBeanMapper resultBeanMapper;
    @Autowired
    WeekBeanMapper weekBeanMapper;
    @Autowired
    StatisticBeanMapper statisticBeanMapper;
    @Autowired
    SemesterBeanMapper semesterBeanMapper;
    @Autowired
    StringCheck stringCheck;

    /**
     * 页面查询数据
     * @param sid
     * @param seid
     * @return
     */
    public Msg getRunningData(Integer sid,Integer seid) {
        //提取跑步成绩,跑步总次数
        StudentBean studentBean = studentBeanMapper.selectByPrimaryKey(sid);
        Integer srun = studentBean.getSrun();
        Integer snt = studentBean.getSnt();

        //提取考试及格的次数
        ResultBeanExample resultBeanExample = new ResultBeanExample();
        ResultBeanExample.Criteria resultcriteria = resultBeanExample.createCriteria();
        //及格的次数
        resultcriteria.andRresultEqualTo(60);
        List<ResultBean> resultBeans = resultBeanMapper.selectByExample(resultBeanExample);
        Integer minresult = resultBeans.get(0).getMinresult();

        //学期内跑步总公里数
        List<WeekBean> weekBeanList = weekBeanMapper.selectBySeid(seid);
        double ALlMileage = 0;
        for (int i = 0; i<weekBeanList.size();i++){
            Integer wid = weekBeanList.get(i).getWid();
            StatisticBeanExample statisticBeanExample = new StatisticBeanExample();
            StatisticBeanExample.Criteria statisticBeanExampleCriteria = statisticBeanExample.createCriteria();
            statisticBeanExampleCriteria.andSidEqualTo(sid);
            statisticBeanExampleCriteria.andWidEqualTo(wid);
            statisticBeanExample.setOrderByClause("sttime DESC");
            List<StatisticBean> statisticBeanList = statisticBeanMapper.selectByExample(statisticBeanExample);
            System.out.println(statisticBeanList.get(0));
            if (statisticBeanList.size()!=0) {
                if (statisticBeanList.get(0).getMileage().equals("")&&statisticBeanList.get(0).getMileage().equals(null)) {
                    String mileage = statisticBeanList.get(0).getMileage();
                    double kilometer = stringCheck.transformStringToDecimal(mileage);
                    ALlMileage += kilometer;
                }
            }
        }

        //跑步记录
        //当前周次
        WeekBeanExample weekBeanExample = new WeekBeanExample();
        weekBeanExample.setOrderByClause("wid DESC");
        List<WeekBean> weekBeans = weekBeanMapper.selectByExample(weekBeanExample);
        Integer wid =weekBeans.get(0).getWid();
        StatisticBeanExample statisticExample = new StatisticBeanExample();
        //statisticExample.setOrderByClause("sttime DESC");
        StatisticBeanExample.Criteria exampleCriteria = statisticExample.createCriteria();
        exampleCriteria.andSidEqualTo(sid);
        exampleCriteria.andWidEqualTo(wid);
        List<StatisticBean> statisticBeans = statisticBeanMapper.selectByExample(statisticExample);
        for (StatisticBean statisticBean : statisticBeans){
            if (statisticBean.getSttime()!=null) {
                String weekDays = dateToWeek(statisticBean.getSttime());
                statisticBean.setWeekDays(weekDays);
            }
        }
        /*List<StatisticBean> statisticBeanList = new ArrayList<>();
        for (int i =0;i<4;i++){
            StatisticBean statisticBean = statisticBeans.get(i);
            statisticBeanList.add(statisticBean);
        }
        Collections.reverse(statisticBeanList);//倒序排列
        */

        //返回信息
        return Msg.success().add("srun",srun).add("snt",snt).add("minresult",minresult).add("ALlMileage",ALlMileage)
                .add("runStatistic",statisticBeans);
    }

    /**
     * getRunningData子方法01
     * 将时间转化为日期
     * @param date
     * @return
     */
    public static String dateToWeek(Date date) {
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 指示一个星期中的某天,0代表星期天。
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1 < 0 ? 0 : cal.get(Calendar.DAY_OF_WEEK) - 1;
        return weekDays[w];
    }

    /**
     * 查询学期列表
     * @return
     */
    public Msg getSename() {
        List<SemesterBean> semesterBeans = semesterBeanMapper.selectByExample(null);
        return Msg.success().add("semesterBeans",semesterBeans);
    }

    /**
     * 根据学期放回学生跑步记录
     * @param sid
     * @param seid
     * @return
     */
    public Msg getStatisticBySeid(Integer sid,Integer seid) {
        if (seid==0){
            SemesterBeanExample semesterBeanExample = new SemesterBeanExample();
            semesterBeanExample.setOrderByClause("seid DESC");
            List<SemesterBean> semesterBeans = semesterBeanMapper.selectByExample(semesterBeanExample);
            seid=semesterBeans.get(0).getSeid();
        }
        WeekBeanExample weekBeanExample = new WeekBeanExample();
        WeekBeanExample.Criteria weekBeanExampleCriteria = weekBeanExample.createCriteria();
        weekBeanExampleCriteria.andSeidEqualTo(seid);
        List<WeekBean> weekBeanList = weekBeanMapper.selectByExample(weekBeanExample);
        List<StatisticBean> statisticBeanList = new ArrayList<>();
        for (WeekBean weekBean : weekBeanList){
            StatisticBeanExample statisticExample = new StatisticBeanExample();
            StatisticBeanExample.Criteria exampleCriteria = statisticExample.createCriteria();
            exampleCriteria.andSidEqualTo(sid);
            exampleCriteria.andWidEqualTo(weekBean.getWid());
            List<StatisticBean> statisticBeans = statisticBeanMapper.selectByExample(statisticExample);
            for (StatisticBean statisticBean : statisticBeans){
                statisticBeanList.add(statisticBean);
            }
        }
        return Msg.success().add("statisticBeanList",statisticBeanList);
    }
}



