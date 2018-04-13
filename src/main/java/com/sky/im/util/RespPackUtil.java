package com.sky.im.util;

import com.alibaba.fastjson.JSONObject;
import com.sky.im.dto.request.CheckRequest;
import com.sky.im.dto.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

public class RespPackUtil {
    private static Logger logger = LoggerFactory.getLogger(RespPackUtil.class);
    public static BaseResponse execInvokeService(Object params,ServiceWrapper serviceWrapper,boolean isPrintParam,boolean isPrintResult){
        BaseResponse baseResponse=new BaseResponse();
        Date startTime = new Date();
        StringBuilder strBuff = new StringBuilder();
        StackTraceElement ste = new Exception().getStackTrace()[1];
        //服务方法名
        String methodName = ste.getMethodName();
        //服务类名
        String serviceName = getSimpleClassName(ste.getClassName());
        String facadeName = serviceName.concat(".").concat(methodName);
        String reqStr =null;
        if(params!=null){
            reqStr=JSONObject.toJSONString(params);
        }
        strBuff.append("调用服务==").append(facadeName)
                .append(";日志包装耗时==").append(System.currentTimeMillis()-startTime.getTime()).append(";");
        if (isPrintParam){
            strBuff.append("请求数据==").append(reqStr).append(";");
        }
        Date checkStartTime =new Date();
        //数据检查
        String checkResult=null;
        if(params!=null&&params instanceof CheckRequest){
            checkResult = ((CheckRequest)params).check();
            strBuff.append("检查数据合法性耗时==").append(System.currentTimeMillis()-checkStartTime.getTime()).append(";");
        }
        String resultCode = null;
        Exception ex = null;
        if (StringUtils.isEmpty(checkResult)) {
            try{
                baseResponse= serviceWrapper.invokeService();
            }catch(Exception e){//服务异常
                ex = e;
                baseResponse.setCode(BaseResponse.FAIL_CODE);
                baseResponse.setMessage(e.getMessage());
                e.printStackTrace();
                strBuff.append("执行异常==").append(e.getMessage()).append(";");
                //异常预警
            }
        } else {//参数缺失
            baseResponse.setCode(BaseResponse.FAIL_CODE);
            baseResponse.setMessage(checkResult);
            strBuff.append("检测到数据错误描述==").append(checkResult).append(";");
        }
        String respStr = JSONObject.toJSONString(baseResponse);
        strBuff.append("resultCode==").append(baseResponse.getCode()).append(";共耗时==")
                .append(System.currentTimeMillis()-startTime.getTime());
        if (isPrintResult){
            strBuff.append(";response==").append(respStr).append(";");
        }
        if(BaseResponse.SUCCESS_CODE.equals(baseResponse.getCode())){
            //服务成功但调用时间过长
            if(serviceWrapper.isMonitorSuccess() || System.currentTimeMillis() - startTime.getTime() > serviceWrapper.timeout()){
                logger.info(strBuff.toString());
            }else{
                logger.debug(strBuff.toString());
            }
        }else{//是否监控+是否忽略失败的操作
            if(ex != null){//服务异常
                strBuff.append(";error_msg==");
                Throwable cause = ex.getCause();
                if(isTimeoutThrowable(cause)){//超时异常
                    strBuff.append(cause.getMessage());
                    logger.error(strBuff.toString());
                }else{
                    strBuff.append(ex.getMessage());
                    logger.error(strBuff.toString(), ex);
                }
            }else{
                logger.info(strBuff.toString());
            }
        }
        return baseResponse;

    }
    //获取服务类名
    private static String getSimpleClassName(String className){
        return className.substring(className.lastIndexOf(".")+1);
    }
    //判断是否超时或者网络方面的异常
    public static boolean isTimeoutThrowable(Throwable cause){
        if(cause != null && (cause instanceof TimeoutException
//				|| cause instanceof HessianConnectionException tanjiaqi
                || cause instanceof SocketTimeoutException
                || cause instanceof ConnectException)){
            return true;
        }else{
            return false;
        }
    }
}
