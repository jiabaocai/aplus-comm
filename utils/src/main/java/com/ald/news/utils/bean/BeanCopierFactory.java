package com.ald.news.utils.bean;

import org.springframework.cglib.beans.BeanCopier;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yangfeng
 * @date 2018/1/18
 * 对象拷贝工程类
 */
public final class BeanCopierFactory {

    static final Map<String, org.springframework.cglib.beans.BeanCopier> BEAN_COPIERS = new ConcurrentHashMap<>();

    /**
     * 获取拷贝工厂
     * @param source
     * @param target
     * @return
     */
    public static org.springframework.cglib.beans.BeanCopier getBeanCopier(Class source, Class target) {
        String key = genKey(source, target);
        org.springframework.cglib.beans.BeanCopier copier;
        if (!BEAN_COPIERS.containsKey(key)) {
            copier = BeanCopier.create(source, target, false);
            BEAN_COPIERS.put(key, copier);
        } else {
            copier = BEAN_COPIERS.get(key);
        }
        return copier;
    }

    private static String genKey(Class<?> srcClazz, Class<?> destClazz) {
        return srcClazz.getName() + destClazz.getName();
    }
}
