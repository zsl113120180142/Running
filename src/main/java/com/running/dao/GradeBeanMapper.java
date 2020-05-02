package com.running.dao;

import com.running.bean.GradeBean;
import com.running.bean.GradeBeanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GradeBeanMapper {
    long countByExample(GradeBeanExample example);

    int deleteByExample(GradeBeanExample example);

    int deleteByPrimaryKey(Integer gid);

    int insert(GradeBean record);

    int insertSelective(GradeBean record);

    List<GradeBean> selectByExample(GradeBeanExample example);

    GradeBean selectByPrimaryKey(Integer gid);

    List<GradeBean> selectByCid(Integer cid);

    int updateByExampleSelective(@Param("record") GradeBean record, @Param("example") GradeBeanExample example);

    int updateByExample(@Param("record") GradeBean record, @Param("example") GradeBeanExample example);

    int updateByPrimaryKeySelective(GradeBean record);

    int updateByPrimaryKey(GradeBean record);
}