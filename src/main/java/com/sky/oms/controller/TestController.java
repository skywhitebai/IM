package com.sky.oms.controller;

import com.sky.oms.dto.response.BaseResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("test")
@RestController
public class TestController {

    @RequestMapping("getErro")
    public BaseResponse getErro(){
        Integer a=1;
        Integer b=0;
        a=a/b;
        return BaseResponse.successData(a);
    }
}
