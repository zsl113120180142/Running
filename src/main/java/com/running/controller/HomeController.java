package com.running.controller;

import com.running.bean.*;
import com.running.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台：用于处理首页面请求
 */
@Controller
public class HomeController {

    @Autowired
    HomeService homeService;

    /**
     * 树形结构：学院【{
     * 年级【{
     * 班级
     * }】
     * }】
     */
    @ResponseBody
    @RequestMapping("/HomePage")
    public Msg HomePage() {
        //数据库取出全部菜单
        List<CollegeBean> Allcollege = homeService.getschool();//学院
        List<GradeBean> Allgrade = homeService.getgrade();//年级
        List<ClassesBean> Allclasses = homeService.getclasses();//班级
        Map<Object,Object> map = new HashMap<>();
        map.put("college",Allcollege);
        map.put("grade",Allgrade);
        map.put("classes",Allclasses);
        /*
        后台形成树形结构，试了很多方法，在贴合数据库的情况下，以下版本是最接近成功的，但还有较大的瑕疵，遂不启用
        */
        /*List<Object> schol = new ArrayList<>();
        for (int i = 0; i < Allcollege.size(); i++) {
            for (int j = 0; j < Allgrade.size(); j++) {
                Map<Object, Object> list = new HashMap<>();
                List<Object> grades = new ArrayList<>();
                if (Allcollege.get(i).getCid() == Allgrade.get(j).getCid()) {
                    list.put("college", Allcollege.get(i).toString());
                    grades.add(Allgrade.get(j).toString());
                    list.put("grade", grades);
                    for (int n = 0; n < Allclasses.size(); n++) {
                        if (Allcollege.get(i).getCid() == Allgrade.get(j).getCid()
                                && Allgrade.get(j).getGid() == Allclasses.get(n).getGid()) {
                            grades.add(Allclasses.get(n).toString());
                        }
                    }
                }
                schol.add(list);
            }
        }*/
        return Msg.success().add("map", map);
    }

    /**
     * 返回学期和周数
     * @return
     */
    @ResponseBody
    @RequestMapping("/getWeek")
    public Msg getWeek(){
        Map<Object,Object> map = new HashMap<>();
        List<SemesterBean> semesterBeans = homeService.getWeek();
        map.put("学期",semesterBeans);
        for (int i=0;i<semesterBeans.size();i++){
            Integer seid = semesterBeans.get(i).getSeid();
            List<WeekBean> weekBeans = homeService.findBySe(seid);
            map.put("第"+i+"学期",weekBeans);
        }
        return Msg.success().add("map", map);
    }

    /**
     * 根据周数返回跑步记录
     */
    @ResponseBody
    @RequestMapping("/getSta")
    public Msg getstaByweek( @RequestParam(value = "wid") Integer wid){
        List<StatisticBean> statistic = homeService.getSta(wid);
        return Msg.success().add("跑步信息",statistic);
    }

    /**
     * 根据班级id删除班级
     */
    @ResponseBody
    @RequestMapping(value="/deleteclasses/{clid}",method= RequestMethod.PUT)
    public Msg deleteclasses(ClassesBean classesBean){
        homeService.deleteByClid(classesBean);
        return Msg.success();
    }

    /**
     * 根据年级id删除年级
     */
    @ResponseBody
    @RequestMapping(value="/deletegrade/{gid}",method= RequestMethod.PUT)
    public Msg deletegrade(GradeBean gradeBean){
        homeService.deleteByGid(gradeBean);
        return Msg.success();
    }
}
