package com.sky.oms.service.impl;

import com.sky.oms.dto.request.AddCommUserRequest;
import com.sky.oms.common.constant.CommonUserConstant;
import com.sky.oms.dao.CommonUserMapper;
import com.sky.oms.dto.request.LoginRequest;
import com.sky.oms.dto.response.BaseResponse;
import com.sky.oms.model.CommonUser;
import com.sky.oms.model.CommonUserExample;
import com.sky.oms.service.ICommonUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

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

    public BaseResponse<CommonUser> login(LoginRequest params) {
        StringBuilder sbErro=new StringBuilder();
        if(StringUtils.isEmpty(params.getUserName())){
            sbErro.append(",").append(CommonUserConstant.USER_NAME_EMPTY);
        }
        if(StringUtils.isEmpty(params.getPassword())){
            sbErro.append(",").append(CommonUserConstant.PASSWORD_NAME_EMPTY);
        }
        if(sbErro.length()>0){
            return BaseResponse.failMessage(sbErro.substring(1));
        }
        CommonUserExample commonUserExample=new CommonUserExample();
        commonUserExample.createCriteria().andUserNameEqualTo(params.getUserName());
        List<CommonUser> commonUserList=commonUserMapper.selectByExample(commonUserExample);
        if(commonUserList==null||commonUserList.size()==0){
            return BaseResponse.failMessage(CommonUserConstant.USER_NAME_NOT_EXIST);
        }
        CommonUser commonUser=commonUserList.get(0);
        if(!params.getPassword().equals(commonUser.getPassword())){
            return BaseResponse.failMessage(CommonUserConstant.PASSWORD_ERRO);
        }
        return BaseResponse.successData(commonUser);
    }
}
