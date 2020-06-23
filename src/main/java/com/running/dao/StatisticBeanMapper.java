package com.running.dao;

import com.running.bean.StatisticBean;
import com.running.bean.StatisticBeanExample;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface StatisticBeanMapper {
    long countByExample(StatisticBeanExample example);

    int deleteByExample(StatisticBeanExample example);

    int deleteByPrimaryKey(Integer stid);

    int insert(StatisticBean record);

    int insertSelective(StatisticBean record);

    List<StatisticBean> selectByExample(StatisticBeanExample example);

    StatisticBean selectByPrimaryKey(Integer stid);

    int updateByExampleSelective(@Param("record") StatisticBean record, @Param("example") StatisticBeanExample example);

    int updateByExample(@Param("record") StatisticBean record, @Param("example") StatisticBeanExample example);

    int updateByPrimaryKeySelective(StatisticBean record);

    int updateByPrimaryKey(StatisticBean record);

    List<StatisticBean> selectByWid(Integer wid);

    long countByExampleandsex(HashMap<Object, Object> map);
}