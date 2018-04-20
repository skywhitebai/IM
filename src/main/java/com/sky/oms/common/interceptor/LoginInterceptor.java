package com.sky.oms.common.interceptor;

import com.sky.oms.common.annotation.Action;
import com.sky.oms.common.annotation.Login;
import com.sky.oms.common.enums.LoginEnum;
import com.sky.oms.dto.response.BaseResponse;
import com.sky.oms.util.LoginUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * 登录拦截器，做登录校验
 * @author Administrator
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 登录权限验证
     * <p>
     * 方法拦截 Controller 处理之前进行调用。
     * </p>
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        /**
         * 处理 Controller 方法
         * <p>
         * 判断 handler 是否为 HandlerMethod 实例
         * </p>
         */
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            Login login = method.getAnnotation(Login.class);
            if (login != null) {
                if (login.action() == Action.Skip) {
                    /**
                     * 忽略拦截
                     */
                    return true;
                }
            }

            /**
             * 正常执行 判断是否登录
             */
            Long userId= LoginUtil.getCurrentUserId(request);
            if(userId==null){
                //如果是ajax请求 弹出错误提醒 如果是页面请求 跳到登录页
                getUnLoginReponse(response);
                return false;
            }
            return true;
        }

        /**
         * 通过拦截
         */
        return true;
    }

    private void getUnLoginReponse(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        BaseResponse baseResponse=BaseResponse.baseEnum(LoginEnum.LOGIN_DISABLE);
        out.print(JSONObject.fromObject(baseResponse));
        out.flush();
    }

}
