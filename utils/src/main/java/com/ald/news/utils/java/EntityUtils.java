package com.ald.news.utils.java;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: aplus
 * @Version 1.0.0
 * @description: 工具类
 * @author: Mr.cai
 * @create: 2019-01-04 14:13
 * @CopyRight 本内容仅限于北境内部传阅，禁止外泄以及用于其他的商业目的
 **/
public class EntityUtils {
    /**
     * 实体类转Map
     *
     * @param object
     * @return
     */
    public static Map<String, Object> entityToMap(Object object) {
        Map<String, Object> map = new HashMap();
        for (Field field : object.getClass().getDeclaredFields()) {
            try {
                boolean flag = field.isAccessible();
                field.setAccessible(true);
                Object o = field.get(object);
                map.put(field.getName(), o);
                field.setAccessible(flag);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    /**
     * Map转实体类
     *
     * @param map    需要初始化的数据，key字段必须与实体类的成员名字一样，否则赋值为空
     * @param entity 需要转化成的实体类
     * @return
     */
    public static <T> T mapToEntity(Map<String, Object> map, Class<T> entity) {
        T t = null;
        try {
            t = entity.newInstance();
            for (Field field : entity.getDeclaredFields()) {
                if (map.containsKey(field.getName())) {
                    boolean flag = field.isAccessible();
                    field.setAccessible(true);
                    Object object = map.get(field.getName());
                    if (object != null && field.getType().isAssignableFrom(object.getClass())) {
                        field.set(t, object);
                    }
                    field.setAccessible(flag);
                }
            }
            return t;
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return t;
    }
}


 
