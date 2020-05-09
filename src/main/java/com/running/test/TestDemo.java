package com.running.test;


import com.running.bean.*;
import com.running.dao.SemesterBeanMapper;
import com.running.dao.WeekBeanMapper;
import com.running.service.HomeService;
import com.running.service.LoginService;
import com.running.service.StuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLOutput;
import java.util.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applictaionContext.xml"})

public class TestDemo {

    @Autowired
    LoginService loginService;

    @Autowired
    HomeService homeService;
    @Autowired
    SemesterBeanMapper semesterBeanMapper;
    @Autowired
    WeekBeanMapper weekBeanMapper;
    @Autowired
    StuService stuService;

    @Test
    public void mytest() {
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
        System.out.println(colleges);
    }
}
