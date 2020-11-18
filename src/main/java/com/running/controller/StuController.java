package com.running.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.running.bean.Msg;
import com.running.bean.StatisticBean;
import com.running.bean.StudentBean;
import com.running.service.StuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台：用于处理学生请求
 */

@Api(tags ="用于处理学生")
@RequestMapping("/stu")
@RestController
public class StuController {

    @Autowired
    StuService stuService;


    /**
     * 通过clid显示学生信息
     *
     * @return
     */
    @ApiOperation("通过clid显示学生信息")
    @GetMapping("/getStuByclid")
    public Msg findStuByClid(@RequestParam(value = "clid") Integer clid,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        PageHelper.startPage(pageNum, pageSize);
        List<StudentBean> studentBeans = stuService.StuByClid(clid);
        PageInfo page = new PageInfo(studentBeans, 10);
        return Msg.success().add("student", page);
    }

    /**
     * 模糊查询（通过姓名）
     */
    @ApiOperation("模糊查询（通过姓名）")
    @GetMapping("/searchSname")
    public Msg search(@RequestParam(value = "clid") Integer clid,
                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                      @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                      @RequestParam(value = "sname", defaultValue = "0") String sname
    ) {
        PageHelper.startPage(pageNum, pageSize);
        List<StudentBean> studentBeans = stuService.searchsname(clid,sname);
        PageInfo page = new PageInfo(studentBeans, 10);
        return Msg.success().add("search", page);
    }



    /**
     * 新增学生
     */
    @ApiOperation("新增学生")
    @PostMapping("/addStu")
    public Msg addStu(@RequestBody StudentBean studentBean) {
        stuService.addStu(studentBean);
        return Msg.success();
    }

    /**
     * 修改学生信息
     * 兼删除学生信息 sdelete=0
     */
    @ApiOperation("修改学生信息,兼删除学生信息 sdelete=0")
    @PutMapping("/updateStu")
    public Msg updateStu(@RequestBody StudentBean studentBean) {
        stuService.updateStu(studentBean);
        return Msg.success();
    }

    /**
     * 显示学生跑步记录
     *
     * @param sid
     * @return
     */
    @ApiOperation("显示学生跑步记录")
    @GetMapping("/RunRecord")
    public Msg RunRecord(@RequestParam(value = "sid") Integer sid) {
        StudentBean studentBean = stuService.StudentRecord(sid);
        List<StatisticBean> statisticBeans = stuService.RunRecord(sid);
        return Msg.success().add("StudentRecord", studentBean).add("RunRecord", statisticBeans);
    }


}
