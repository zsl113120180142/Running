package com.running.controller;

import com.running.bean.*;
import com.running.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
     * 页面显示请求
     */
    @ResponseBody
    @RequestMapping("/HomePage")
    public Msg HomePage(@RequestParam(value = "wid", defaultValue = "1") Integer wid){
        List<CollegeBean> college = homeService.getschool();
        Map<Object,Object> map = new HashMap<Object, Object>();
        map.put("college", college);
        for (int i=0 ; i<college.size();i++){
            Integer cid= college.get(i).getCid();
            List<GradeBean> grade =  homeService.findByCid(cid);
            if (grade!=null){
                map.put("grade"+i,grade);
            }
            for (int j=0 ; j<grade.size() ; j++){
                Integer gid = grade.get(j).getGid();
                List<ClassesBean> classes = homeService.findByGid(gid);
                if (classes != null){
                    map.put("classes"+j,classes);
                }
            }
        }
        List<SemesterBean> semesterBeans = homeService.getWeek();
        map.put("学期",semesterBeans);
        for (int i=0;i<semesterBeans.size();i++){
            Integer seid = semesterBeans.get(i).getSeid();
            List<WeekBean> weekBeans = homeService.findBySe(seid);
            map.put("第"+i+"学期",weekBeans);
        }

        return Msg.success().add("map",map);
    }
}
