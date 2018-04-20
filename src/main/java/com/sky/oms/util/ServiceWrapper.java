package com.sky.oms.util;

import com.sky.oms.dto.response.BaseResponse;

public abstract class ServiceWrapper {
    //调用服务
    public abstract BaseResponse invokeService() throws Exception;

    //是否监控失败请求
    public boolean isMonitorFail(){
        return true;
    }

    //是否监控成功请求
    public boolean isMonitorSuccess(){
        return false;
    }

    //超时时间
    public int timeout(){
        return 300;
    }

    //是否通知调用失败
    public boolean isNoticeInvokeFail(){
        return false;
    }

    //获取请求traceId
    public String getTraceId(){
        return null;
    }

    //发送变更通知
    public Boolean sendChangeNotify(){
        return null;
    }
}
