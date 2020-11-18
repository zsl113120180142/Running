package com.running.service.mobile;

import com.running.bean.*;
import com.running.dao.*;
import com.running.method.StringCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: MoblieRunService
 * @Description: 移动端跑步的业务逻辑
 * @Author: zsl
 * @Date: 2020/8/25 23:18
 * @Version: v1.0
 */
@Service
public class MoblieRunService {

    @Autowired
    RuleBeanMapper ruleBeanMapper;
    @Autowired
    StudentBeanMapper studentBeanMapper;
    @Autowired
    StatisticBeanMapper statisticBeanMapper;
    @Autowired
    StringCheck stringCheck;
    @Autowired
    WeekBeanMapper weekBeanMapper;
    @Autowired
    ClassesBeanMapper classesBeanMapper;
    @Autowired
    GradeBeanMapper gradeBeanMapper;

    /**
     * 学生显示页面
     * @param sid
     * @return
     */
    public Msg selectMobileRun(Integer sid) {
        //获取学生信息
        StudentBean studentBean = studentBeanMapper.selectByPrimaryKey(sid);
        String sex = studentBean.getSex();

        //获取目标距离
        List<RuleBean> ruleBeanList  = selectRuleBySex(sex);
        String rkm = ruleBeanList.get(0).getRkm();
        //获取本周完成数
        StatisticBeanExample statisticBeanExample = new StatisticBeanExample();
        statisticBeanExample.setOrderByClause("stid DESC");
        List<StatisticBean> statisticBeanList = statisticBeanMapper.selectByExample(statisticBeanExample);
        Integer stnt = statisticBeanList.get(0).getStnt();

        return Msg.success().add("rkm",rkm).add("stnt",stnt);
    }

    /**
     * 根据性别获取相应的规则
     * @param sex
     * @return
     */
    public List<RuleBean> selectRuleBySex(String sex){
        //获取性别对应的规则
        RuleBeanExample ruleBeanExample = new RuleBeanExample();
        RuleBeanExample.Criteria ruleBeanExampleCriteria = ruleBeanExample.createCriteria();
        ruleBeanExampleCriteria.andSexEqualTo(sex);
        List<RuleBean> ruleBeanList = ruleBeanMapper.selectByExample(ruleBeanExample);
        return ruleBeanList;
    }

    /**
     * 判断时间
     * @param sid
     * @return
     */
    public Msg judgeTime(Integer sid) throws ParseException {
        //获取学生信息
        StudentBean studentBean = studentBeanMapper.selectByPrimaryKey(sid);
        String sex = studentBean.getSex();
        //获取规则
        List<RuleBean> ruleBeanList  = selectRuleBySex(sex);
        String starttime1 = ruleBeanList.get(0).getStarttime();
        String endtime1 = ruleBeanList.get(0).getEndtime();
        String starttime2 = ruleBeanList.get(1).getStarttime();
        String endtime2 = ruleBeanList.get(1).getEndtime();
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        String nowsd = format.format(new Date());
        //时间个是转化
        Date morning1 = stringCheck.transformStringToDate(starttime1);
        Date morning2 = stringCheck.transformStringToDate(endtime1);
        Date afternoon1 = stringCheck.transformStringToDate(starttime2);
        Date afternoon2 = stringCheck.transformStringToDate(endtime2);
        Date nowtime = stringCheck.transformStringToDate(nowsd);

        boolean choose1 = morning1.before(nowtime)&&morning2.after(nowtime);
        boolean choose2 = afternoon1.before(nowtime)&&afternoon2.after(nowtime);
        if (choose1 || choose2){
            return Msg.success().add("err","允许跑步");
        }else {
            return Msg.fail().add("err","请在规定时间内跑步");
        }


    }

    /**
     * 判断数据是否合格后，新增数据
     * @param statisticBean
     * @return
     * @throws ParseException
     */
    public Msg addStatistic(StatisticBean statisticBean) throws ParseException {
        Integer sid = statisticBean.getSid();
        StudentBean studentBean = studentBeanMapper.selectByPrimaryKey(sid);
        String sex = studentBean.getSex();
        //获取规则
        List<RuleBean> ruleBeanList  = selectRuleBySex(sex);
        //字符串转化
        double rkm = stringCheck.transformStringToDecimal(ruleBeanList.get(0).getRkm());
        double mileage = stringCheck.transformStringToDecimal(statisticBean.getMileage());
        Date rtime= stringCheck.transformStringToDate(ruleBeanList.get(0).getRtime());
        Date runtime = stringCheck.transformStringToDate(statisticBean.getRuntime());
        if (rkm*1000<=mileage && rtime.after(runtime)){
            //往里面添加数据
            WeekBeanExample weekBeanExample = new WeekBeanExample();
            weekBeanExample.setOrderByClause("wid DESC");
            List<WeekBean> weekBeanList = weekBeanMapper.selectByExample(weekBeanExample);
            Integer wid = weekBeanList.get(0).getWid();
            statisticBean.setWid(wid);
            statisticBean.setClid(studentBean.getClid());
            ClassesBean classesBean = classesBeanMapper.selectByPrimaryKey(studentBean.getClid());
            statisticBean.setGid(classesBean.getGid());
            GradeBean gradeBean = gradeBeanMapper.selectByPrimaryKey(classesBean.getGid());
            statisticBean.setCid(gradeBean.getCid());
            statisticBean.setSttime(new Date());

            int e = statisticBeanMapper.insertSelective(statisticBean);
            if (e<0){
                return Msg.success();
            }else {
                return Msg.fail();
            }
        }else {
            return Msg.fail().add("err","该成绩不符合要求");
        }
    }
}
