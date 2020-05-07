package com.running.dao;

import com.running.bean.StudentBean;
import com.running.bean.StudentBeanExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface StudentBeanMapper {
    long countByExample(StudentBeanExample example);

    int deleteByExample(StudentBeanExample example);

    int deleteByPrimaryKey(Integer sid);

    int insert(StudentBean record);

    int insertSelective(StudentBean record);

    List<StudentBean> selectByExample(StudentBeanExample example);

    StudentBean selectByPrimaryKey(Integer sid);

    int updateByExampleSelective(@Param("record") StudentBean record, @Param("example") StudentBeanExample example);

    int updateByExample(@Param("record") StudentBean record, @Param("example") StudentBeanExample example);

    int updateByPrimaryKeySelective(StudentBean record);

    int updateByPrimaryKey(StudentBean record);

    List<StudentBean> selectByClid(Integer clid);

    List<StudentBean> searchsname(Map<Object, Object> map);
}