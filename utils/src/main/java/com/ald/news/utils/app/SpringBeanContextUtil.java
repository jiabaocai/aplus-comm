package com.ald.news.utils.app;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * 获取容器bean
 */
@Component
public class SpringBeanContextUtil implements ApplicationContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBeanContextUtil.class);
    public static final String DEFAULT_SESSION_FACTORY = "mySessionFactory";
    private static ApplicationContext appContext;
    private static boolean devMode = false;

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        appContext = ctx;
    }

    public static ApplicationContext get() {
        return appContext;
    }

    public static Object getBean(String beanName) {
        return appContext.getBean(beanName);
    }

    public static boolean containsBean(String beanName) {
        return appContext.containsBean(beanName);
    }

    public static <T> T getBean(String beanName, Class<T> type) {
        return appContext.getBean(beanName, type);
    }

    public static boolean isReady() {
        return appContext != null;
    }

    public static boolean isDevMode() {
        return devMode;
    }

    public void setDevMode(boolean devMode) {
        SpringBeanContextUtil.devMode = devMode;
        LOGGER.info("Debug[devMode] is -------------------{}-------------------", devMode ? "ON" : "OFF");
    }
}