package com.running.dao;

import com.running.bean.ResultBean;
import com.running.bean.ResultBeanExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ResultBeanMapper {
    long countByExample(ResultBeanExample example);

    int deleteByExample(ResultBeanExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(ResultBean record);

    int insertSelective(ResultBean record);

    List<ResultBean> selectByExample(ResultBeanExample example);

    ResultBean selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") ResultBean record, @Param("example") ResultBeanExample example);

    int updateByExample(@Param("record") ResultBean record, @Param("example") ResultBeanExample example);

    int updateByPrimaryKeySelective(ResultBean record);

    int updateByPrimaryKey(ResultBean record);
}