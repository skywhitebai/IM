package com.sky.oms.dao;

import com.alibaba.fastjson.JSON;
import com.sky.oms.BaseJunitTest;
import com.sky.oms.model.CommonUser;
import org.junit.Test;

import javax.annotation.Resource;

public class CommonUserMapperTest extends BaseJunitTest {
    @Resource
    CommonUserMapper commonUserMapper;
    @Test
    public  void getUser(){
        CommonUser a=commonUserMapper.selectByPrimaryKey(1L);
        System.out.println(JSON.toJSONString(a));
    }

}
