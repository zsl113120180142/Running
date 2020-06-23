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
        Integer wid =1;
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
    }
}
