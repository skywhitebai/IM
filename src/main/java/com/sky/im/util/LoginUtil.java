package com.sky.im.util;

import com.sky.im.common.constant.CommonUserConstant;
import com.sky.im.model.CommonUser;

import javax.servlet.http.HttpServletRequest;

public  class LoginUtil {
    public static CommonUser getCurrentUser(HttpServletRequest request){
       Object currentUserInfo=request.getSession().getAttribute(CommonUserConstant.LOGIN_SESSION);
       if(currentUserInfo==null){
           return null;
       }
       else{
           return (CommonUser) currentUserInfo;
       }
    }
    public static Long getCurrentUserId(HttpServletRequest request){
        CommonUser commonUser=getCurrentUser(request);
        if(commonUser==null){
            return null;
        }
        else{
            return commonUser.getUserId();
        }
    }
}
