package com.sky.oms.dao;

import com.alibaba.fastjson.JSON;
import com.sky.oms.BaseJunitTest;
import com.sky.oms.model.CommonUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.transaction.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-mvc.xml","classpath*:spring-mybatis.xml"})
@Transactional
public class CommonUserMapperTest2 {
    @Resource
    CommonUserMapper commonUserMapper;
    @Test
    public  void getUser(){
        CommonUser a=commonUserMapper.selectByPrimaryKey(1L);
        System.out.println(JSON.toJSONString(a));
    }

}
