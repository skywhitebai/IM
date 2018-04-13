package com.sky.im.dto.request;

import com.sky.im.util.ApiParamCheckUtil;

public class CheckRequest {
    public String check() {
        return ApiParamCheckUtil.checkParam(this);
    }
}
