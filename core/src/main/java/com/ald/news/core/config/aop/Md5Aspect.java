package com.ald.news.core.config.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


/**
 * 需要校验的MD5的切面处理类
 */
@Aspect
@Component
@Configuration
public class Md5Aspect {
    protected static final Logger logger = LoggerFactory.getLogger(Md5Aspect.class);

    @Around("@annotation(com.ald.news.core.config.aop.Md5)")
    public Object insertAccessLog(ProceedingJoinPoint jp) throws Throwable {
        return null;
    }

}
