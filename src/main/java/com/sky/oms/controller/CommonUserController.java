package com.sky.oms.controller;

import com.alibaba.fastjson.JSON;
import com.sky.oms.model.CommonUser;
import com.sky.oms.dto.request.AddCommUserRequest;
import com.sky.oms.dto.response.BaseResponse;
import com.sky.oms.service.ICommonUserService;
import com.sky.oms.util.ServiceWrapper;
import com.sky.oms.util.RespPackUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("commonUser")
public class CommonUserController extends  SuperController{
    @Autowired
    ICommonUserService commonUserService;

    Logger logger = LoggerFactory.getLogger(CommonUserController.class);

    @RequestMapping("showUser")
    public String toIndex(HttpServletRequest request, Model model, Long id) {

        Long userId = Long.getLong(request.getParameter("id"));
        CommonUser commonUser = commonUserService.getCommonUserById(id);
        model.addAttribute("commonUser", commonUser);
        return "showUser";
    }

    @RequestMapping("showUser2")
    @ResponseBody
    public CommonUser showUser2(Long id) {

        // Long userId=Long.getLong(request.getParameter("id"));
        CommonUser commonUser = commonUserService.getCommonUserById(id);
        logger.info("commonUser:{}", JSON.toJSON(commonUser));
        return commonUser;
    }

    @RequestMapping("getUser")
    @ResponseBody
    public BaseResponse getUser(final Long userId) {
        final Long currentUserId=123L;
        return RespPackUtil.execInvokeService(userId,
                new ServiceWrapper() {
                    @Override
                    public BaseResponse invokeService() throws Exception {
                        CommonUser result = commonUserService.getCommonUserById(userId);
                        logger.info(String.valueOf(currentUserId));
                        return BaseResponse.successData(result);
                    }
                }
                , true, true);
    }
    @RequestMapping("addUser")
    @ResponseBody
    public BaseResponse addUser(final AddCommUserRequest params) {
        final Long userId=123L;
        return RespPackUtil.execInvokeService(params,
                new ServiceWrapper() {
                    @Override
                    public BaseResponse invokeService() throws Exception {
                        BaseResponse result = commonUserService.add(params);
                        logger.info(String.valueOf(userId));
                        return result;
                    }
                }
                , true, true);
    }
    @RequestMapping("downExcel")
    @ResponseBody
    public BaseResponse downExcel() {

       return BaseResponse.success();
    }

}



