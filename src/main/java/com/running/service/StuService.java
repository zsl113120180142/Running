package com.running.service;

import com.running.bean.SemesterBean;
import com.running.bean.StudentBean;
import com.running.dao.StudentBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * 处理后台页面请求
 */
@Service
public class StuService {

    @Autowired
    StudentBeanMapper studentBeanMapper;

    /**
     * 通过clid查询班级的学生信息
     * @param clid
     * @return
     */
    public List<StudentBean> StuByClid(Integer clid) {
        return studentBeanMapper.selectByClid(clid);
    }

    /**
     * 通过模糊查询的关键字进行查询
     * clid进行维持
     * @param map
     * @return
     */
    public List<StudentBean> searchsname(Map<Object, Object> map) {
        return studentBeanMapper.searchsname(map);
    }

    /**
     *新增学生
     * @param studentBean
     */
    public void addStu(StudentBean studentBean) {
        studentBeanMapper.insertSelective(studentBean);
    }

    /**
     * 修改学生信息
     * 兼删除学生信息 sdelete=0
     * @param studentBean
     */
    public void updateStu(StudentBean studentBean) {
        studentBeanMapper.updateByPrimaryKeySelective(studentBean);
    }


}
