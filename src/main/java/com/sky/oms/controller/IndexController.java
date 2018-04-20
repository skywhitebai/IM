package com.sky.oms.controller;

import com.sky.oms.common.annotation.Action;
import com.sky.oms.common.annotation.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController extends SuperController {
    /**
     * 首页
     * @return
     */
    @RequestMapping(value = {"index","/","home"})
    public String login() {
        return "index";
    }
}
