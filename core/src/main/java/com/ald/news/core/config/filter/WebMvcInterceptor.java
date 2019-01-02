package com.ald.news.core.config.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * baojun - 2017/12/21
 * 自定义 web 拦截器
 */
@Configuration
public class WebMvcInterceptor extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ShiroPermissionInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
