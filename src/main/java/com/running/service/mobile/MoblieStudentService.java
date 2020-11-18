package com.running.service.mobile;

import com.running.bean.*;
import com.running.dao.ClassesBeanMapper;
import com.running.dao.CollegeBeanMapper;
import com.running.dao.GradeBeanMapper;
import com.running.dao.StudentBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: MoblieStudentService
 * @Description: TODO
 * @Author: zsl
 * @Date: 2020/8/26 14:20
 * @Version: v1.0
 */
@Service
public class MoblieStudentService {
    @Autowired
    StudentBeanMapper studentBeanMapper;
    @Autowired
    ClassesBeanMapper classesBeanMapper;
    @Autowired
    GradeBeanMapper gradeBeanMapper;
    @Autowired
    CollegeBeanMapper collegeBeanMapper;


    public Msg selectStudent(Integer sid) {
        if (sid==null){
            return Msg.fail();
        }
        StudentBean studentBean = studentBeanMapper.selectByPrimaryKey(sid);
        ClassesBean classesBean = classesBeanMapper.selectByPrimaryKey(studentBean.getClid());
        String clname = classesBean.getClname();
        GradeBean gradeBean = gradeBeanMapper.selectByPrimaryKey(classesBean.getGid());
        CollegeBean collegeBean = collegeBeanMapper.selectByPrimaryKey(gradeBean.getCid());
        String cname = collegeBean.getCname();
        return Msg.success().add("studentBean",studentBean).add("clname",clname).add("cname",cname);
    }


    public Msg updataStudent(StudentBean studentBean) {
        int i = studentBeanMapper.updateByPrimaryKeySelective(studentBean);
        if (i<0){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
}
