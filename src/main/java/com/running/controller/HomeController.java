package com.running.controller;

import com.running.bean.*;
import com.running.service.HomeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
     * 三层树形结构
     * @return
     */

    @ResponseBody
    @GetMapping("/HomePage")
    public Msg HomePage() {
        //数据库取出全部菜单
        List<CollegeBean> Allcollege = homeService.getschool();//学院
        List<GradeBean> Allgrade = homeService.getgrade();//年级
        List<ClassesBean> Allclasses = homeService.getclasses();//班级
        List<Object> colleges = new ArrayList<>();
        for (int i=0 ; i < Allcollege.size();i++){
            Map<Object,Object> obj = new HashMap<>();
            obj.put("college",Allcollege.get(i).toString());
            List<Object> csub = new ArrayList<>();
            obj.put("csub",csub);
            for (int j=0;j<Allgrade.size();j++){
                Map<Object,Object> gobj = new HashMap<>();
                if (Allcollege.get(i).getCid()==Allgrade.get(j).getCid()){
                    gobj.put("grade",Allgrade.get(j).toString());
                    csub.add(gobj);
                }
                List<Object> gsub = new ArrayList<>();
                gobj.put("gsub",gsub);
                for (int n=0;n<Allclasses.size();n++){
                    if (Allgrade.get(j).getGid()==Allclasses.get(n).getGid()){
                        Map<Object,Object> clobj = new HashMap<>();
                        clobj.put("classes",Allclasses.get(n).toString());
                        gsub.add(clobj);
                    }
                }
            }
            colleges.add(obj);
        }
        return Msg.success().add("colleges", colleges);
    }

    /**
     * 返回学期和周数
     * @return
     */
    @ResponseBody
    @GetMapping("/getWeek")
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
     * @param wid
     * @return
     */
    @ResponseBody
    @GetMapping("/getSta")
    public Msg getstaByweek(@RequestParam(value ="wid") Integer wid){
        //跑0圈的男生数
        Integer stnt0 = 0;
        String sex1 ="男";
        long zeroboy = homeService.sta(wid,stnt0,sex1);
        //跑一圈的男生数
        Integer stnt1 = 1;
        long oneboy = homeService.sta(wid,stnt1,sex1);
        //跑两圈的男生数
        Integer stnt2 = 2;
        long twoboy = homeService.sta(wid,stnt2,sex1);
        //跑0圈的女生数
        String sex2 ="女";
        long zerogril = homeService.sta(wid,stnt0,sex2);
        //跑一圈的女生数
        long onegril = homeService.sta(wid,stnt1,sex2);
        //跑两圈的女生数
        long twogril = homeService.sta(wid,stnt2,sex2);
        //所有男生
        long allboy = zeroboy+oneboy+twoboy;
        //所有女生
        long allgril = zerogril+onegril+twogril;
        return Msg.success()
                .add("zeroboy",zeroboy)
                .add("oneboy",oneboy)
                .add("twoboy",twoboy)
                .add("zerogril",zerogril)
                .add("onegril",onegril)
                .add("twogril",twogril)
                .add("allboy",allboy)
                .add("allgril",allgril);
    }

    /**
     * 根据班级id删除班级
     * @param classesBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/deleteclasses/{clid}",method= RequestMethod.PUT)
    public Msg deleteclasses(ClassesBean classesBean){
        homeService.deleteByClid(classesBean);
        return Msg.success();
    }

    /**
     * 根据年级id删除年级
     * @param gradeBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/deletegrade/{gid}",method= RequestMethod.PUT)
    public Msg deletegrade(GradeBean gradeBean){
        homeService.deleteByGid(gradeBean);
        return Msg.success();
    }
}
