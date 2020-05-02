package com.running.dao;

import com.running.bean.WeekBean;
import com.running.bean.WeekBeanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeekBeanMapper {
    long countByExample(WeekBeanExample example);

    int deleteByExample(WeekBeanExample example);

    int deleteByPrimaryKey(Integer wid);

    int insert(WeekBean record);

    int insertSelective(WeekBean record);

    List<WeekBean> selectByExample(WeekBeanExample example);

    WeekBean selectByPrimaryKey(Integer wid);

    List<WeekBean> selectBySeid(Integer seid);

    int updateByExampleSelective(@Param("record") WeekBean record, @Param("example") WeekBeanExample example);

    int updateByExample(@Param("record") WeekBean record, @Param("example") WeekBeanExample example);

    int updateByPrimaryKeySelective(WeekBean record);

    int updateByPrimaryKey(WeekBean record);
}