package com.sky.oms.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sky.oms.common.constant.CommonUserConstant;
import com.sky.oms.model.CommonUser;
import com.sky.oms.dto.response.BaseResponse;
import com.sky.oms.util.LoginUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class SuperController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	protected HttpServletResponse response;

	@Autowired
	protected HttpSession session;

	@Autowired
	protected ServletContext application;

	protected Long getCurrentUserId() {
		return null;
	}
	protected CommonUser getCurrentUserInfoS() {
		return LoginUtil.getCurrentUser(request);
	}
	protected BaseResponse<CommonUser> getCurrentUserInfoResponseS() {
		CommonUser commonUser=LoginUtil.getCurrentUser(request);
		if(commonUser==null){
			return  BaseResponse.failMessage("获取当前用户信息失败，用户未登录或登录超时");
		}else{
			return BaseResponse.successData(commonUser);
		}
	}
	void doLogout(){
		request.getSession().removeAttribute(CommonUserConstant.LOGIN_SESSION);
	}
}
