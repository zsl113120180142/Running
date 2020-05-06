package com.running.dao;

import com.running.bean.ClassesBean;
import com.running.bean.ClassesBeanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassesBeanMapper {
    long countByExample(ClassesBeanExample example);

    int deleteByExample(ClassesBeanExample example);

    int deleteByPrimaryKey(Integer clid);

    int insert(ClassesBean record);

    int insertSelective(ClassesBean record);

    List<ClassesBean> selectByExample(ClassesBeanExample example);

    ClassesBean selectByPrimaryKey(Integer clid);

    int updateByExampleSelective(@Param("record") ClassesBean record, @Param("example") ClassesBeanExample example);

    int updateByExample(@Param("record") ClassesBean record, @Param("example") ClassesBeanExample example);

    int updateByPrimaryKeySelective(ClassesBean record);

    int updateByPrimaryKey(ClassesBean record);

    List<ClassesBean> selectByGid(Integer gid);
}