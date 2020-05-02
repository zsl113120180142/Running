package com.running.test;


import com.running.bean.*;
import com.running.dao.AdminBeanMapper;
import com.running.dao.SemesterBeanMapper;
import com.running.dao.WeekBeanMapper;
import com.running.service.HomeService;
import com.running.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @Test
    public void mytest() {
        List<SemesterBean> semesterBeans = homeService.getWeek();
        System.out.println(semesterBeans);
        for (int i=0;i<semesterBeans.size();i++){
            Integer seid = semesterBeans.get(i).getSeid();
            List<WeekBean> weekBeans = homeService.findBySe(seid);
            System.out.println(weekBeans);
        }
    }
//	
}
