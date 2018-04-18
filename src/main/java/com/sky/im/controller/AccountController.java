package com.sky.im.controller;

import com.sky.im.common.annotation.Action;
import com.sky.im.common.annotation.Login;
import com.sky.im.common.constant.CommonUserConstant;
import com.sky.im.dto.request.LoginRequest;
import com.sky.im.dto.response.BaseResponse;
import com.sky.im.model.CommonUser;
import com.sky.im.service.ICommonUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("account")
public class AccountController extends SuperController {
    @Autowired
    ICommonUserService commonUserService;
    Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 登录
     * @param params
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    @Login(action = Action.Skip)
    public BaseResponse login(LoginRequest params) {
        BaseResponse<CommonUser> baseResponse=commonUserService.login(params);
        //如果登录成功
        if(BaseResponse.SUCCESS_CODE.equals(baseResponse.getCode())){
            request.getSession().setAttribute(CommonUserConstant.LOGIN_SESSION,baseResponse.getData());
        }
        return baseResponse;
    }

    /**
     * 退出登录
     * @param params
     * @return
     */
    @RequestMapping("logout")
    @ResponseBody
    @Login(action = Action.Skip)
    public BaseResponse logout(LoginRequest params) {
        doLogout();
        return BaseResponse.success();
    }
    /**
     * 获取当前登录用户信息
     * @return
     */
    @RequestMapping("getCurrentUserInfo")
    @ResponseBody
    public BaseResponse getCurrentUserInfo() {
        return getCurrentUserInfoResponseS();
    }
}
