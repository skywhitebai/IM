package com.sky.oms.dao;

import com.sky.oms.model.TaskDealExample;
import com.sky.oms.model.TaskDeal;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TaskDealMapper {
    int countByExample(TaskDealExample example);

    int deleteByExample(TaskDealExample example);

    int insert(TaskDeal record);

    int insertSelective(TaskDeal record);

    List<TaskDeal> selectByExample(TaskDealExample example);

    int updateByExampleSelective(@Param("record") TaskDeal record, @Param("example") TaskDealExample example);

    int updateByExample(@Param("record") TaskDeal record, @Param("example") TaskDealExample example);
}