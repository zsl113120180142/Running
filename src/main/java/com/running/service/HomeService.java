package com.running.service;

import com.running.bean.*;
import com.running.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    



    /**
     * 三维数组
     * 显示学院，年级，班级
     */
    public List<CollegeBean> getschool() {
        return collegeBeanMapper.selectByExample(null);
    }
    public List<GradeBean> getgrade(){
        return gradeBeanMapper.selectAllgrade();
    }
    public List<ClassesBean> getclasses(){
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
     * @return
     */
    public List<SemesterBean> getWeek() {
        return semesterBeanMapper.selectByExample(null);
    }
    public  List<WeekBean> findBySe(Integer seid) {
        return weekBeanMapper.selectBySeid(seid);
    }

    /**
     * 通过周次查询数据
     * @param wid
     * @return
     */
    public List<StatisticBean> getSta(Integer wid) {
        return statisticBeanMapper.selectByWid(wid);
    }

    /**
     * 通过clid删除
     * 实际上是修改cldelete=0
     * @param classesBean
     */
    public void deleteByClid(ClassesBean classesBean) {
        classesBeanMapper.updateByPrimaryKeySelective(classesBean);
    }

    /**
     * 通过gid删除
     * 实际上是修改gdelete=0
     * @param gradeBean
     */
    public void deleteByGid(GradeBean gradeBean) {
        gradeBeanMapper.updateByPrimaryKeySelective(gradeBean);
    }
}
