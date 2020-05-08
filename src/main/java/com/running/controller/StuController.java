package com.running.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.running.bean.Msg;
import com.running.bean.SemesterBean;
import com.running.bean.StudentBean;
import com.running.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台：用于处理学生请求
 */
@Controller
public class StuController {

    @Autowired
    StuService stuService;

    /**
     * 通过clid显示学生信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/getStuByclid")
    public Msg findStuByClid(@RequestParam(value = "clid") Integer clid,
                             @RequestParam(value = "pn", defaultValue = "1") Integer pn
                             ){
        PageHelper.startPage(pn, 10);
        List<StudentBean> studentBeans = stuService.StuByClid(clid);
        PageInfo page = new PageInfo(studentBeans,10);
        return Msg.success().add("student",page);
    }

    /**
     * 模糊查询（通过姓名）
     */
    @ResponseBody
    @RequestMapping("/searchSname")
    public Msg search(@RequestParam(value = "clid") Integer clid,
                      @RequestParam(value = "pn", defaultValue = "1") Integer pn,
                      @RequestParam(value = "sname") String sname
                      ){
        PageHelper.startPage(pn, 10);
        Map<Object,Object> map = new HashMap<>();
        map.put("clid",clid);
        map.put("sname",sname);
        List<StudentBean> studentBeans = stuService.searchsname(map);
        PageInfo page = new PageInfo(studentBeans,10);
        return Msg.success().add("search",page);
    }

    /**
     * 新增学生
     */
    @ResponseBody
    @RequestMapping(value="/addStu",method= RequestMethod.POST)
    public Msg addStu(StudentBean studentBean){
        stuService.addStu(studentBean);
    return Msg.success();
    }

    /**
     * 修改学生信息
     * 兼删除学生信息 sdelete=0
     */
    @ResponseBody
    @RequestMapping(value="/updateStu/{sid}",method=RequestMethod.PUT)
    public Msg updateStu(StudentBean studentBean){
        stuService.updateStu(studentBean);
        return Msg.success();
    }



}
