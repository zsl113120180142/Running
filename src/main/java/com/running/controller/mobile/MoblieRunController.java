package com.running.controller.mobile;

import com.running.bean.Msg;
import com.running.bean.StatisticBean;
import com.running.service.mobile.MoblieRunService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * @ClassName: MoblieRunController
 * @Description: 移动端跑步的事务请求
 * @Author: zsl
 * @Date: 2020/8/25 23:15
 * @Version: v1.0
 */
@Api(tags ="移动端跑步的事务请求")
@RestController
@RequestMapping("/mobile")
public class MoblieRunController {
    @Autowired
    MoblieRunService moblieRunService;

    /**
     * 跑步页面的显示
     * @param sid
     * @return
     */
    @ApiOperation("跑步页面的显示")
    @GetMapping("/selectMobileRun")
    public Msg selectMobileRun(@RequestParam("sid") Integer sid){
        Msg msg = moblieRunService.selectMobileRun(sid);
        return msg;
    }

    /**
     * 判断是否是在规定时间内跑步
     * @param sid
     * @return
     * @throws ParseException
     */
    @ApiOperation("判断是否是在规定时间内跑步")
    @GetMapping("/judgeTime")
    public Msg judgeTime(@RequestParam("sid") Integer sid) throws ParseException {
        Msg msg = moblieRunService.judgeTime(sid);
        return msg;
    }

    /**
     * 判断数据是否合格后，新增数据
     * sid stnt mileage runtime
     * @param statisticBean
     * @return
     * @throws ParseException
     */
    @ApiOperation("判断数据是否合格后，新增数据")
    @PostMapping("/addStatistic")
    public Msg addStatistic(@RequestBody StatisticBean statisticBean) throws ParseException {
        Msg msg = moblieRunService.addStatistic(statisticBean);
        return msg;
    }
}
