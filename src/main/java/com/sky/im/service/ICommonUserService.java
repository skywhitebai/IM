package com.sky.im.service;

import com.sky.im.dto.request.AddCommUserRequest;
import com.sky.im.dto.request.LoginRequest;
import com.sky.im.dto.response.BaseResponse;
import com.sky.im.model.CommonUser;

public interface ICommonUserService {
    public CommonUser getCommonUserById(Long userId);

    BaseResponse add(AddCommUserRequest params);

    BaseResponse login(LoginRequest params);
}
