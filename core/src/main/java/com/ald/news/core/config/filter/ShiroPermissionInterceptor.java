package com.ald.news.core.config.filter;

import com.ald.news.utils.Constants;
import com.ald.news.utils.app.ServletUtils;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * baojun - 2017/12/21
 * 自定义shiro权限拦截器
 */
public class ShiroPermissionInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod newhandler = (HandlerMethod) handler;
            RequiresPermissions permAnnotation = newhandler.getMethodAnnotation(RequiresPermissions.class);
            boolean isPermission = true;
//        boolean isPermission = false;
//        Subject currentUser = SecurityUtils.getSubject();
//         //没有获得注解  及不需要权限-- 则直接运行
//        if(null!=permAnnotation){
//            String permission = permAnnotation.value()[0];
//            //当前登录人 具有权限
//            if(currentUser.isPermitted(permission)){
//            	isPermission = true;
//            }
//        }else{
//        	isPermission = true;
//        }
            if (isPermission) {
                //有执行方法或权限不拦截
                return true;
            } else {
                Map<String, Object> res = new HashMap<String, Object>();
                res.put(Constants.Global.RESPONSE_CODE, Constants.ResponseCode.PERM_CODE_VALUE);
                res.put(Constants.Global.RESPONSE_MSG, "无此权限");
                ServletUtils.writeToResponse(response, res);
                return false;
//            throw new AuthorizationException();  //无权限异常
            }
        } else {
            return super.preHandle(request, response, handler);
        }
    }
}
