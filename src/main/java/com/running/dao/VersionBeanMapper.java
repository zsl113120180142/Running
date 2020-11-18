package com.running.dao;

import com.running.bean.VersionBean;
import com.running.bean.VersionBeanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VersionBeanMapper {
    long countByExample(VersionBeanExample example);

    int deleteByExample(VersionBeanExample example);

    int deleteByPrimaryKey(Integer vid);

    int insert(VersionBean record);

    int insertSelective(VersionBean record);

    List<VersionBean> selectByExample(VersionBeanExample example);

    VersionBean selectByPrimaryKey(Integer vid);

    int updateByExampleSelective(@Param("record") VersionBean record, @Param("example") VersionBeanExample example);

    int updateByExample(@Param("record") VersionBean record, @Param("example") VersionBeanExample example);

    int updateByPrimaryKeySelective(VersionBean record);

    int updateByPrimaryKey(VersionBean record);
}