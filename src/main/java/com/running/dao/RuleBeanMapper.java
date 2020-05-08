package com.running.dao;

import com.running.bean.RuleBean;
import com.running.bean.RuleBeanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RuleBeanMapper {
    long countByExample(RuleBeanExample example);

    int deleteByExample(RuleBeanExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(RuleBean record);

    int insertSelective(RuleBean record);

    List<RuleBean> selectByExample(RuleBeanExample example);

    RuleBean selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") RuleBean record, @Param("example") RuleBeanExample example);

    int updateByExample(@Param("record") RuleBean record, @Param("example") RuleBeanExample example);

    int updateByPrimaryKeySelective(RuleBean record);

    int updateByPrimaryKey(RuleBean record);
}