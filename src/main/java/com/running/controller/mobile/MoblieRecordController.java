package com.running.controller.mobile;

import com.running.bean.Msg;
import com.running.service.mobile.MoblieRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: MoblieRecord
 * @Description: 移动端数据记录页面
 * @Author: zsl
 * @Date: 2020/8/25 17:20
 * @Version: v1.0
 */
@Api(tags ="移动端数据记录页面")
@RequestMapping("/mobile")
@RestController
public class MoblieRecordController {

    @Autowired
    MoblieRecordService mobleRecordService;

    /**
     * 查询学期列表
     * @return
     */
    @ApiOperation("查询学期列表")
    @GetMapping("/getSename")
    public Msg getSename(){
        Msg msg = mobleRecordService.getSename();
        return msg;
    }

    /**
     * 页面查询数据
     * @param sid
     * @param seid
     * @return
     */
    @ApiOperation("页面查询数据")
    @GetMapping("/getRunningData")
    public Msg getRunningData(@RequestParam("sid") Integer sid,
                              @RequestParam("seid") Integer seid){
        Msg msg = mobleRecordService.getRunningData(sid,seid);
        return msg;
    }

    @ApiOperation("根据学期id返回记录")
    @GetMapping("/getStatisticByClid")
    public Msg getStatisticByClid(@RequestParam("sid") Integer sid,
                                  @RequestParam(value = "seid",defaultValue = "0") Integer seid){
        Msg msg = mobleRecordService.getStatisticBySeid(sid,seid);
        return msg;
    }


}
