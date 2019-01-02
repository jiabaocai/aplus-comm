package com.ald.news.utils.bean;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yangfeng
 * @date 2018/1/18
 * 对象复制工具
 */
public final class BeanCopier {

    /**
     * 根据属性名和类型匹配 深度拷贝列表
     *
     * @param destClass
     * @param srcList
     * @return srcList为null或空数组时，均返回空数组。
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static final <K, T> List<T> copyBeanList(Class<T> destClass, List<K> srcList) {
        List<T> destList = new ArrayList<>();
        if (destClass == null || CollectionUtils.isEmpty(srcList)) {
            return destList;
        }

        org.springframework.cglib.beans.BeanCopier copier = BeanCopierFactory.getBeanCopier(srcList.get(0).getClass(),
                destClass);
        try {
            for (Object src : srcList) {
                T obj = destClass.newInstance();
                copier.copy(src, obj, null);
                destList.add(obj);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return destList;
    }

    /**
     * 根据属性名和类型匹配 将一个或多个对象深度拷贝至一个对象
     *
     * @param destClass
     * @param srcArray
     * @return srcArray内所有成员均为null时，则返回null。
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static final <T> T copyBean(Class<T> destClass, Object... srcArray) {
        if (destClass == null || isAllNull(srcArray)) {
            return null;
        }
        T destObj = null;
        try {
            destClass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        for (Object srcObj : srcArray) {
            if (srcObj == null) {
                continue;
            }
            org.springframework.cglib.beans.BeanCopier copier = BeanCopierFactory.getBeanCopier(srcObj.getClass(),
                    destObj.getClass());
            copier.copy(srcObj, destObj, null);
        }
        return destObj;
    }

    private static boolean isAllNull(Object... srcArray) {
        if (srcArray == null || srcArray.length == 0) {
            return true;
        }
        boolean isAllSrcNull = true;
        for (Object src : srcArray) {
            if (src != null) {
                isAllSrcNull = false;
                break;
            }
        }
        return isAllSrcNull;
    }

    /**
     * 根据属性名和类型匹配 将一个或多个对象深度拷贝至一个对象
     *
     * @param destObj
     * @param srcArray
     * @return srcArray内所有成员均为null时，则返回null。
     */
    public static final <T> T copyBean(T destObj, Object... srcArray) {
        if (destObj == null || isAllNull(srcArray)) {
            return null;
        }
        for (Object srcObj : srcArray) {
            if (srcObj == null) {
                continue;
            }
            org.springframework.cglib.beans.BeanCopier copier = BeanCopierFactory.getBeanCopier(srcObj.getClass(),
                    destObj.getClass());
            copier.copy(srcObj, destObj, null);
        }
        return destObj;
    }
}
