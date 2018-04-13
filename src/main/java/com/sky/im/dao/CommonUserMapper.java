package com.sky.im.dao;

import com.sky.im.model.CommonUser;
import com.sky.im.model.CommonUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommonUserMapper {
    int countByExample(CommonUserExample example);

    int deleteByExample(CommonUserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(CommonUser record);

    int insertSelective(CommonUser record);

    List<CommonUser> selectByExample(CommonUserExample example);

    CommonUser selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") CommonUser record, @Param("example") CommonUserExample example);

    int updateByExample(@Param("record") CommonUser record, @Param("example") CommonUserExample example);

    int updateByPrimaryKeySelective(CommonUser record);

    int updateByPrimaryKey(CommonUser record);
}