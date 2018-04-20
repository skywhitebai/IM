package com.sky.oms.service;

import com.sky.oms.model.CommonUser;
import com.sky.oms.dto.request.AddCommUserRequest;
import com.sky.oms.dto.request.LoginRequest;
import com.sky.oms.dto.response.BaseResponse;

public interface ICommonUserService {
    public CommonUser getCommonUserById(Long userId);

    BaseResponse add(AddCommUserRequest params);

    BaseResponse<CommonUser> login(LoginRequest params);
}
