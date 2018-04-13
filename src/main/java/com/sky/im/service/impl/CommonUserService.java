package com.sky.im.service.impl;

import com.sky.im.dao.CommonUserMapper;
import com.sky.im.dto.request.AddCommUserRequest;
import com.sky.im.dto.response.BaseResponse;
import com.sky.im.model.CommonUser;
import com.sky.im.service.ICommonUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommonUserService implements ICommonUserService {
    @Resource
    CommonUserMapper commonUserMapper;
    public CommonUser getCommonUserById(Long userId) {
        return commonUserMapper.selectByPrimaryKey(userId);
    }

    public BaseResponse add(AddCommUserRequest params) {
        CommonUser commonUser=new CommonUser();
        BeanUtils.copyProperties(params,commonUser);
        int res=commonUserMapper.insert(commonUser);
        if(res>0){
            return BaseResponse.successData(commonUser.getUserId());
        }
        else{
            return BaseResponse.fail();
        }
    }
}
