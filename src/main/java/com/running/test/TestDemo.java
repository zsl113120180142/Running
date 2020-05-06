package com.running.test;


import com.running.bean.*;
import com.running.dao.SemesterBeanMapper;
import com.running.dao.WeekBeanMapper;
import com.running.service.HomeService;
import com.running.service.LoginService;
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

    @Test
    public void mytest() {
        Integer wid = 1;
        List<StatisticBean> statistic = homeService.getSta(wid);
        System.out.println(statistic);
    }
}
