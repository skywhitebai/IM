package com.sky.oms.dto.request;

import com.sky.oms.util.ApiParamCheckUtil;

public class CheckRequest {
    public String check() {
        return ApiParamCheckUtil.checkParam(this);
    }
}
