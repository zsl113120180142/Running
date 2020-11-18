package com.running.test;


import com.running.dao.SemesterBeanMapper;
import com.running.dao.WeekBeanMapper;
import com.running.service.AutomationService;
import com.running.service.HomeService;
import com.running.service.LoginService;
import com.running.service.StuService;
import com.running.service.mobile.MoblieRecordService;
import com.running.service.mobile.MoblieRunService;
import com.running.service.mobile.VersionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


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
    @Autowired
    MoblieRecordService mobleRecordService;
    @Autowired
    MoblieRunService moblieRunService;
    @Autowired
    AutomationService automationService;
    @Autowired
    VersionService versionService;

    @Test
    public void mytest() {
        System.out.println(homeService.DistinctStatistic(62,0,0,0));
    }
}
