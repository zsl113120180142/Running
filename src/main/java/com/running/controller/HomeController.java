package com.running.controller;

import com.running.bean.*;
import com.running.service.HomeService;
import com.running.service.RuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 后台：用于处理首页面请求
 */
@Api(tags ="后台首页面")
@RequestMapping("/home")
@RestController
public class HomeController {

    @Autowired
    HomeService homeService;
    @Autowired
    RuleService ruleService;

    /**
     * 三层树形结构
     *
     * @return
     */
    @ApiOperation("三层树形结构")
    @GetMapping("/HomePage")
    public Msg HomePage() {
        //数据库取出全部菜单
        List<CollegeBean> Allcollege = homeService.getschool();//学院

        for (int i = 0; i < Allcollege.size(); i++) {
            Integer cid = Allcollege.get(i).getCid();
            List<GradeBean> gradeBeanList = homeService.findByCid(cid);
            //去重
            List<GradeBean> gradeBeanList2 = gradeBeanList.stream()
                    .collect(Collectors.collectingAndThen(
                            Collectors.toCollection(() -> new TreeSet<>(
                                    Comparator.comparing(GradeBean::getGname))), ArrayList::new));
            Allcollege.get(i).setGradeBeanList(gradeBeanList2);
            for (GradeBean gradeBean : gradeBeanList2) {
                Integer gname = gradeBean.getGname();
                List<GradeBean> gradeBeanList3= homeService.findBycidAndName(cid,gname);
                List<ClassesBean> classesBeanListson = new ArrayList<>();
                for (int j = 0; j < gradeBeanList3.size(); j++) {
                    Integer gid = gradeBeanList3.get(j).getGid();
                    List<ClassesBean> classesBeanList = homeService.findByGid(gid);
                    classesBeanListson.add(classesBeanList.get(0));
                }
                gradeBean.setClassesBeanList(classesBeanListson);
            }
        }
        return Msg.success().add("Allcollege",Allcollege);
    }

    /**
     * 返回学期和周数
     * 学院，年级，班级 ，
     * @return
     */
    @ApiOperation("下拉框，返回学期和周数，学院，年级，班级")
    @GetMapping("/getWeek")
    public Msg getWeek() {
        List<SemesterBean> semesterBeans = homeService.getWeek();
        for (int i = 0; i < semesterBeans.size(); i++) {
            Integer seid = semesterBeans.get(i).getSeid();
            List<WeekBean> weekBeans = homeService.findBySe(seid);
            semesterBeans.get(i).setWeekBeanList(weekBeans);
        }
        List<CollegeBean> collegeBeanList = homeService.selectCollegeAndGradeAndClasses();
        return Msg.success().add("semesterBeans", semesterBeans).add("collegeBeanList",collegeBeanList);
    }

    /**
     * 根据周数返回跑步记录
     *
     * @param wid
     * @return
     */
    @ApiOperation("根据学期（不能为空），周数，学院，年级，班级返回跑步记录")
    @GetMapping("/getSta")
    public Msg getstaByweek(
            @RequestParam(value = "seid") Integer seid,
            @RequestParam(value = "wid", defaultValue = "0") Integer wid,
            @RequestParam(value = "cid", defaultValue = "0") Integer cid,
            @RequestParam(value = "gid", defaultValue = "0") Integer gid,
            @RequestParam(value = "clid", defaultValue = "0") Integer clid
            ) {
       Msg msg =  homeService.sta(seid,wid,cid,gid,clid);
       return msg;
    }

    /**
     * 根据班级id删除班级
     *
     * @return
     */
    @ApiOperation("根据班级id删除班级")
    @PutMapping("/deleteclasses")
    public Msg deleteclasses(@RequestParam("clid") Integer clid) {
        homeService.deleteByClid(clid);
        return Msg.success();
    }

    /**
     * 根据年级id删除年级
     *
     * @return
     */
    @ApiOperation("根据年级id删除年级")
    @PutMapping("/deletegrade")
    public Msg deletegrade(@RequestParam( "gid") Integer gid) {
        homeService.deleteByGid(gid);
        return Msg.success();
    }

    @ApiOperation("显示当前学期，当前周信息")
    @GetMapping("/NowSemesterAndWeek")
    public Msg NowSemesterAndWeek(){
        Msg msg = ruleService.NowSemesterAndWeek();
        return msg;
    }
}
