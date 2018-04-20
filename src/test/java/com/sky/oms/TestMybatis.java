package com.sky.oms;

import com.alibaba.fastjson.JSON;
import com.sky.oms.model.CommonUser;
import com.sky.oms.service.ICommonUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestMybatis {

    Logger logger= LoggerFactory.getLogger(TestMybatis.class);
    @Autowired
    ICommonUserService commonUserService;
    //  @Before
//  public void before() {
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//      userService = (IUserService) ac.getBean("userService");
//  }

    @Test
    public void test1() {
        CommonUser commonUser = commonUserService.getCommonUserById(1L);
        logger.info(JSON.toJSONString(commonUser));
    }
}
