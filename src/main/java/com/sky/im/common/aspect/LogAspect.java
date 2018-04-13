package com.sky.im.common.aspect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.sky.im.common.annotation.Log;
import com.sky.im.dto.response.BaseResponse;
import com.sky.im.util.DateUtil;
import com.sky.im.util.HttpUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     *
     * @Description: 方法调用前触发 记录开始时间
     * @author fei.lei
     * @date 2016年11月23日 下午5:10
     * @param joinPoint
     */
    public void before(JoinPoint joinPoint) {

    }

    /**
     *
     * @Description: 方法调用后触发 记录结束时间
     * @author fei.lei
     * @date 2016年11月23日 下午5:10
     * @param joinPoint
     */
    public void after(JoinPoint joinPoint) {

    }

    /**
     * @Description: 获取request
     * @author fei.lei
     * @date 2016年11月23日 下午5:10
     * @param
     * @return HttpServletRequest
     */
    public HttpServletRequest getHttpServletRequest() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        return request;
    }

    /**
     *
     * @Title：around
     * @Description: 环绕触发
     * @author fei.lei
     * @date 2016年11月23日 下午5:10
     * @param joinPoint
     * @return Object
     * @throws Throwable
     */
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Date startTime; // 开始时间
        Date endTime; // 结束时间
//        CurrentUserInfo currentUserInfo = null;
        HttpServletRequest request = null;
        String operName = "";
        startTime = new Date(); // 记录方法开始执行的时间
        request = getHttpServletRequest();
        Long userId=null;
        // currentUserInfo =LoginHelper.getCurrentUserInfo(request);
        // 获取class和method
        Signature signature = joinPoint.getSignature();
        Method method = ((MethodSignature) signature).getMethod();
        Log log = method.getAnnotation(Log.class);
        if (log != null) {
            operName = log.value();
        }

        StringBuilder sb = new StringBuilder();

        sb.append("-----------------------")
                .append(DateUtil.getFormatSSS(startTime))
                .append("-------------------------------------\n");

        sb.append("Controller: ")
                .append(joinPoint.getTarget().getClass().getName())
                .append("\n");
        sb.append("Method    : ").append(method.getName()).append("\n"); 
        if (joinPoint.getArgs().length > 0) {
			try {
				sb.append("Json      : ")
						.append(JSON.toJSONString(joinPoint.getArgs()))
						.append("\n");
			} catch (Exception e) {
				sb.append("Json      : ").append(joinPoint.getArgs())
						.append("\n");
			}
		}	
		if(request.getParameterMap().size()>0){
			sb.append("Params    : ")
					.append(JSON.toJSONString(request.getParameterMap()))
					.append("\n");
		}
        sb.append("URI       : ").append(request.getRequestURI()).append("\n");
        sb.append("IP        : ").append(HttpUtil.getIp(request)).append("\n");
        if (userId != null) {
            sb.append("DealUser  : ").append("userId:")
                    .append(userId).append("\n");
        }
        if (!StringUtils.isEmpty(operName)) {
            sb.append("operName  : ").append(operName).append("\n");
        }
        logger.info(sb.toString());
        Object result = joinPoint.proceed();
        endTime = new Date();
        StringBuilder sbAfter = new StringBuilder();
        sbAfter.append("CostTime  : ")
                .append(endTime.getTime() - startTime.getTime()).append("ms")
                .append("\n");
        if (result != null && result instanceof BaseResponse) {
            sbAfter.append("Response  : ")
                    .append(JSON.toJSONString(result)).append("\n");

        }
        sbAfter.append("-----------------------")
                .append(DateUtil.getFormatSSS(endTime))
                .append("-------------------------------------\n");

        logger.info(sbAfter.toString());
        return result;
    }

    private String getParams(HttpServletRequest request){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    request.getInputStream()));// post方式传递读取字符流
            String jsonStr = null;
            StringBuilder result = new StringBuilder();
            while ((jsonStr = reader.readLine()) != null) {
                result.append(jsonStr);
            }
            reader.close();// 关闭输入流
            return result.toString();
        } catch (Exception e) {
            logger.error("参数获取错误", e);
            return null;
        }
    }
}
