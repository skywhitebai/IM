package com.sky.im.dao;

import com.sky.im.model.TaskDeal;
import com.sky.im.model.TaskDealExample;
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