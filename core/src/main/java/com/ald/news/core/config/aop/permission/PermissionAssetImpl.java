package com.ald.news.core.config.aop.permission;

import com.ald.news.core.base.BaseResponse;
import com.ald.news.utils.Constants;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * ,___         .-;'
 * `"-.`\_...._/`.`
 * ,       \        /
 * .-' ',      / ()   ()\
 * `'._ \     /()    .  (|
 * > .'  ;,     -'-  /
 * / <   |;,     __.;
 * '-.'-.|  , \    , \
 * `>.|;, \_)    \_)
 * `-;     ,    /
 * \    /   <
 * '. <`'-, _)
 * '._)
 *
 * @Author luohao
 * @Version 1.0.0
 * @Date 17:24 2017/12/8
 * @Desription 权限校验实现类
 * @CopyRight 本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */

@Aspect
@Component
public class PermissionAssetImpl {

    private Logger logger = LoggerFactory.getLogger(PermissionAssetImpl.class);

//    @Resource
//    PermissionService service;

    @Around("@annotation(com.ald.news.core.config.aop.permission.PermissionAsset)")
    public BaseResponse insertAccessLog(ProceedingJoinPoint jp) throws Throwable {


        BaseResponse baseResponse = new BaseResponse();

        /*
         * 定义, token只能放在header中, 且键必须为token
         * 如果使用了zuul且通过验证, 说明本接口token是一定合法
         * 如果没有使用zuul, 则需要经过校验
         * 无论如何, 都需要解析token
         */
        ServletRequestAttributes sra = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
        HttpServletRequest request = sra.getRequest();

        //获取token
        String token = request.getHeader(Constants.Token.KEY);

        Claims claims = this.tokenAccess(token);
        if (claims == null) {
            baseResponse.setCode(201);
            baseResponse.setMsg("token校验失败");
            return baseResponse;
        }

        Long userId = claims.get(Constants.Token.USER_ID, Long.class);
        if (userId == null) {
            baseResponse.setCode(201);
            baseResponse.setMsg("token校验失败");
            return baseResponse;
        }

        /*
         * 按钮级别的权限用正则表达式来做
         * 角色在配置权限的时候需要进行设置占位符区间, 用以满足正则表达式
         *
         * 使用url + 用户编号 --> 定义的reg
         *
         */
        Pattern reg = null;
//        try {
//            if(! service.auth(userId, getAccessUrl(request))){
//                baseResponse.setCode(201);
//                baseResponse.setMsg("访问受限");
//                return baseResponse;
//            }
//        }catch (Exception e){
//            logger.error(this.getClass().getName(), e);
//            baseResponse.setCode(999);
//            baseResponse.setMsg("权限校验发生了一个错误");
//            return baseResponse;
//        }
        return (BaseResponse) jp.proceed();
    }


    /**
     * 获取访问路径, restfull
     *
     * @param request
     * @return
     */
    private String getAccessUrl(HttpServletRequest request) {

        StringBuilder sb = new StringBuilder();
        sb.append(request.getContextPath());
        sb.append(request.getServletPath());

        return sb.toString();

    }

    /**
     * 查询角色是否可以访问这个url
     * 1. 查询到角色和url是否有对应关系
     *
     * @param roleType
     * @param url
     * @return
     */
    private boolean accessAble(Integer roleType, String url) {
        return false;
    }

    /**
     * 从字符串获取token属性值
     *
     * @param tokenStr
     * @return
     */
    private Claims tokenAccess(String tokenStr) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(Constants.Token.SECRET)
                    .requireSubject(Constants.Token.SUBJECT)
                    .parseClaimsJws(tokenStr)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

}
