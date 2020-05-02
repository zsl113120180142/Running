package com.running.dao;

import com.running.bean.CollegeBean;
import com.running.bean.CollegeBeanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollegeBeanMapper {
    long countByExample(CollegeBeanExample example);

    int deleteByExample(CollegeBeanExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(CollegeBean record);

    int insertSelective(CollegeBean record);

    List<CollegeBean> selectByExample(CollegeBeanExample example);

    CollegeBean selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") CollegeBean record, @Param("example") CollegeBeanExample example);

    int updateByExample(@Param("record") CollegeBean record, @Param("example") CollegeBeanExample example);

    int updateByPrimaryKeySelective(CollegeBean record);

    int updateByPrimaryKey(CollegeBean record);
}