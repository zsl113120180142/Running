package com.running.service;

import com.running.bean.*;
import com.running.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 处理后台页面请求
 */
@Service
public class HomeService {

    @Autowired
    CollegeBeanMapper collegeBeanMapper;
    @Autowired
    GradeBeanMapper gradeBeanMapper;
    @Autowired
    ClassesBeanMapper classesBeanMapper;
    @Autowired
    SemesterBeanMapper semesterBeanMapper;
    @Autowired
    WeekBeanMapper weekBeanMapper;
    @Autowired
    StatisticBeanMapper statisticBeanMapper;
    @Autowired
    StudentBeanMapper studentBeanMapper;


    /**
     * 三维数组
     * 显示学院，年级，班级
     */
    public List<CollegeBean> getschool() {
        return collegeBeanMapper.selectByExample(null);
    }

    public List<GradeBean> getgrade() {
        return gradeBeanMapper.selectAllgrade();
    }

    public List<ClassesBean> getclasses() {
        return classesBeanMapper.selectAllclasses();
    }

    public List<GradeBean> findByCid(Integer cid) {
        return gradeBeanMapper.selectByCid(cid);
    }

    public List<ClassesBean> findByGid(Integer gid) {
        return classesBeanMapper.selectByGid(gid);
    }

    /**
     * 返回学期和周数
     *
     * @return
     */
    public List<SemesterBean> getWeek() {
        return semesterBeanMapper.selectByExample(null);
    }

    public List<WeekBean> findBySe(Integer seid) {
        return weekBeanMapper.selectBySeid(seid);
    }

    /**
     * 通过周次查询跑步人数
     *
     * @param wid
     * @return
     */
    public Msg sta(Integer seid, Integer wid, Integer cid, Integer gid, Integer clid) {
        System.out.println(seid);
        Integer b0,b1,b2,g0,g1,g2;
        List<StatisticBean> statisticBeans = new ArrayList<>();
        if (seid==0){
            SemesterBeanExample semesterBeanExample = new SemesterBeanExample();
        }
        if (wid == 0) {
            WeekBeanExample weekBeanExample = new WeekBeanExample();
            WeekBeanExample.Criteria weekBeanExampleCriteria = weekBeanExample.createCriteria();
            weekBeanExampleCriteria.andSeidEqualTo(seid);
            List<WeekBean> weekBeanList = weekBeanMapper.selectByExample(weekBeanExample);
            for (int i = 0; i < weekBeanList.size(); i++) {
                Integer wwid = weekBeanList.get(i).getWid();
                statisticBeans =DistinctStatistic(wwid,cid,gid,clid);
            }
        } else {
            statisticBeans =DistinctStatistic(wid,cid,gid,clid);
        }
        List<StatisticBean> boystatistic = new ArrayList<>();
        List<StatisticBean> grilstatistic = new ArrayList<>();
        List<StudentBean> studentBeanList = studentBeanMapper.selectByExample(null);
        List<Integer> boysid =new ArrayList<Integer>();
        for (StudentBean studentBean : studentBeanList){
            if (studentBean.getSex().equals("男")){
                boysid.add(studentBean.getSid());
            }
        }
        for (StatisticBean statisticBean : statisticBeans){
            Integer sid = statisticBean.getSid();
            if (boysid.contains(sid)){
                boystatistic.add(statisticBean);
            }else{
                grilstatistic.add(statisticBean);
            }
        }
        //男生
        b0 = stntNumber(boystatistic,0);
        b1 =stntNumber(boystatistic,1);
        b2 = stntNumber(boystatistic,2);
        //女生
        g0 =stntNumber(grilstatistic,0);
        g1 =stntNumber(grilstatistic,1);
        g2 =stntNumber(grilstatistic,2);
        //转化为百分数
        DecimalFormat decimalFormat = new DecimalFormat("#0.##%");
        if (boystatistic.size()==0){
            StatisticBean statisticBean = new StatisticBean();
            boystatistic.add(statisticBean);
        }else if (grilstatistic.size()==0){
            StatisticBean statisticBean = new StatisticBean();
            grilstatistic.add(statisticBean);
        }
        return Msg.success()
                .add("boyZeroTimes",decimalFormat.format(b0 / boystatistic.size()))
                .add("boyOnce",decimalFormat.format(b1 / boystatistic.size()))
                .add("boyTwice",decimalFormat.format(b2 / boystatistic.size()))
                .add("girlZeroTimes",decimalFormat.format(g0 / grilstatistic.size()))
                .add("girlOnce",decimalFormat.format(g1 / grilstatistic.size()))
                .add("girlTwice",decimalFormat.format(g2 / grilstatistic.size()))
                .add("b0",b0).add("b1",b1).add("b2",b2).add("allboy",boystatistic.size())
                .add("g0",b0).add("g1",b1).add("g2",b2).add("allgril",grilstatistic.size())
                ;
    }

    /**
     * sta生成子方法01
     * DistinctStatistic去重的列表
     */
    public List<StatisticBean> DistinctStatistic(Integer wid, Integer cid, Integer gid, Integer clid) {
        List<StatisticBean> statisticBeans = new ArrayList<>();
        StatisticBeanExample statisticBeanExample = new StatisticBeanExample();
        statisticBeanExample.setOrderByClause("stid DESC");
        StatisticBeanExample.Criteria statisticBeanExampleCriteria = statisticBeanExample.createCriteria();
        statisticBeanExampleCriteria.andWidEqualTo(wid);
        if (cid != 0) {
            statisticBeanExampleCriteria.andCidEqualTo(cid);
        }
        if (gid != 0) {
            statisticBeanExampleCriteria.andGidEqualTo(gid);
        }
        if (clid != 0) {
            statisticBeanExampleCriteria.andClidEqualTo(clid);
        }
        List<StatisticBean> statisticBeans1 = statisticBeanMapper.selectByExample(statisticBeanExample);
        System.out.println(statisticBeans1);
        List<StatisticBean> statisticBeans2 = statisticBeans1.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(
                                Comparator.comparing(StatisticBean::getSid))), ArrayList::new));
        for (StatisticBean statisticBean : statisticBeans2) {
            statisticBeans.add(statisticBean);
        }
        System.out.println(statisticBeans);
        return statisticBeans;
    }
    /**
     * sta生成子方法02
     * stntNumber得出数量
     */
    public Integer stntNumber(List<StatisticBean> statisticBeans,Integer stnt){
        Integer num =0;
        for (StatisticBean statisticBean : statisticBeans){
            if (statisticBean.getStnt()==stnt){
                num++;
            }
        }
        return num;
    }


    /**
     * 通过clid删除
     * 实际上是修改cldelete=0
     *
     */
    public void deleteByClid(Integer clid) {
        ClassesBean classesBean = new ClassesBean();
        classesBean.setClid(clid);
        classesBean.setCldelete(0);
        classesBeanMapper.updateByPrimaryKeySelective(classesBean);
    }

    /**
     * 通过gid删除
     * 实际上是修改gdelete=0
     *
     */
    public void deleteByGid(Integer gid) {
        GradeBean gradeBean = new GradeBean();
        gradeBean.setGid(gid);
        gradeBean.setGdelete(0);
        gradeBeanMapper.updateByPrimaryKeySelective(gradeBean);
    }

    public List<CollegeBean> selectCollegeAndGradeAndClasses() {
        List<CollegeBean> collegeBeans = collegeBeanMapper.selectByExample(null);
        for (CollegeBean collegeBean : collegeBeans){
            Integer cid = collegeBean.getCid();
            List<GradeBean> gradeBeans = gradeBeanMapper.selectByCid(cid);
            collegeBean.setGradeBeanList(gradeBeans);
            for (GradeBean gradeBean : gradeBeans){
                Integer gid = gradeBean.getGid();
                List<ClassesBean> classesBeans = classesBeanMapper.selectByGid(gid);
                gradeBean.setClassesBeanList(classesBeans);
            }
        }
        return collegeBeans;
    }

    public List<GradeBean> findBycidAndName(Integer cid, Integer gname) {
        GradeBeanExample example = new GradeBeanExample();
        GradeBeanExample.Criteria criteria = example.createCriteria();
        criteria.andCidEqualTo(cid);
        criteria.andGnameEqualTo(gname);
        return gradeBeanMapper.selectByExample(example);
    }
}
