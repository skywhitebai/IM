package com.sky.oms.service;

import com.alibaba.fastjson.JSONObject;
import com.sky.oms.BaseJunitTest;
import com.sky.oms.model.CommonUser;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CommonUserServiceTest extends BaseJunitTest {
    Logger log= LoggerFactory.getLogger(this.getClass());
    @Autowired
    ICommonUserService commonUserService;
    @Test
   public void getUser(){
        CommonUser user=commonUserService.getCommonUserById(1L);
        System.out.println(JSONObject.toJSONString(user));
    }
}
