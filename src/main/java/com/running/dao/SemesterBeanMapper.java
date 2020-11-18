package com.running.dao;

import com.running.bean.SemesterBean;
import com.running.bean.SemesterBeanExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SemesterBeanMapper {
    long countByExample(SemesterBeanExample example);

    int deleteByExample(SemesterBeanExample example);

    int deleteByPrimaryKey(Integer seid);

    int insert(SemesterBean record);

    int insertSelective(SemesterBean record);

    List<SemesterBean> selectByExample(SemesterBeanExample example);

    SemesterBean selectByPrimaryKey(Integer seid);

    int updateByExampleSelective(@Param("record") SemesterBean record, @Param("example") SemesterBeanExample example);

    int updateByExample(@Param("record") SemesterBean record, @Param("example") SemesterBeanExample example);

    int updateByPrimaryKeySelective(SemesterBean record);

    int updateByPrimaryKey(SemesterBean record);
}