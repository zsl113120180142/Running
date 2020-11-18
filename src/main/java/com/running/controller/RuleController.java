package com.running.controller;

import com.running.bean.*;
import com.running.service.AutomationService;
import com.running.service.RuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台：用于规则页面的操作问题
 */
@Api(tags = "处理规则页面")
@RequestMapping("/rule")
@RestController
public class RuleController {

    @Autowired
    RuleService ruleService;
    @Autowired
    AutomationService automationService;

    /*规则*/
    @ApiOperation("新增学期")
    @PostMapping("/addSemester")
    public Msg addSemester(@RequestBody ReceivingRules receivingRules) {
        //增加学期
        SemesterBean semesterBean = receivingRules.getSemesterBean();
        if (semesterBean.getSename() != null) {
            ruleService.addSem(semesterBean);
        }
        return Msg.success();
    }


    /**
     * 修改所有规则
     */
    @ApiOperation("修改所有规则")
    @PutMapping("/updateAll")
    public Msg updateAll(@RequestBody ReceivingRules receivingRules) {
        System.out.println(receivingRules);

        //修改跑步分数设定
        List<ResultBean> resultBeanList = receivingRules.getResultBeanList();
        for (ResultBean resultBean : resultBeanList) {
            ruleService.upateResult(resultBean);
        }
        //修改男女生的跑步信息
        List<RuleBean> ruleBeanList = receivingRules.getRuleBeanList();
        ruleService.upateRule(ruleBeanList);
        //新增周次
        WeekBean weekBean = receivingRules.getWeekBean();
        ruleService.addWeek(weekBean);
        automationService.AutomationIncreaseStatistic();
        return Msg.success();

    }

    /**
     * 显示所有规则信息
     */
    @ApiOperation("显示所有规则信息")
    @GetMapping("/Semester")
    public Msg Semester() {
        //学期信息
        List<SemesterBean> semesterBeans = ruleService.Semester();
        //显示跑步分数设定
        List<ResultBean> resultBeanList = ruleService.getAllResult();
        //显示男女生跑步设定
        List<RuleBean> ruleBeanList = ruleService.getAllRule();
        return Msg.success()
                .add("semesterBeans", semesterBeans)
                .add("resultBeanList", resultBeanList)
                .add("ruleBeanList", ruleBeanList);
    }

    @ApiOperation("显示当前学期，当前周信息")
    @GetMapping("/NowSemesterAndWeek")
    public Msg NowSemesterAndWeek() {
        Msg msg = ruleService.NowSemesterAndWeek();
        return msg;
    }


}
