package com.running.dao;

import com.running.bean.AdminBean;
import com.running.bean.AdminBeanExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AdminBeanMapper {
    long countByExample(AdminBeanExample example);

    int deleteByExample(AdminBeanExample example);

    int deleteByPrimaryKey(Integer aid);

    String selectPassword(Map<String,String> map);

    String selectByUsername(String username);

    int insert(AdminBean record);

    int insertSelective(AdminBean record);

    List<AdminBean> selectByExample(AdminBeanExample example);

    AdminBean selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("record") AdminBean record, @Param("example") AdminBeanExample example);

    int updateByExample(@Param("record") AdminBean record, @Param("example") AdminBeanExample example);

    int updateByPrimaryKeySelective(AdminBean record);

    int updateByPrimaryKey(AdminBean record);

}