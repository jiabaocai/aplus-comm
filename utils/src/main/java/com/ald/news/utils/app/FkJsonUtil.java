package com.ald.news.utils.app;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;

/**
 * @author luohao
 * @version 1.0.0
 * @date 2017-08-08 14:44
 * Copyright 杭州融都科技股份有限公司  arc All Rights Reserved
 * 官方网站：www.erongdu.com
 * 创新一部：rdc@erongdu.com
 * 未经授权不得进行修改、复制、出售及商业使用
 */
public class FkJsonUtil {
    private static ObjectMapper mapper = new ObjectMapper();
    private static ObjectMapper mapperWithYMDDate = new ObjectMapper();

    static {
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        mapperWithYMDDate.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapperWithYMDDate.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        mapperWithYMDDate.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapperWithYMDDate.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapperWithYMDDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
    }


    public static ObjectMapper getJsonMapper() {
        return mapper;
    }

    public static <T> T parse(String value, Class<T> clz) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        try {
            return mapper.readValue(value, clz);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static <T> T parseWithOnlyYMDDate(String value, Class<T> clz) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        try {
            return mapperWithYMDDate.readValue(value, clz);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static <T> T parse(byte[] bytes, Class<T> clz) {
        try {
            return mapper.readValue(bytes, clz);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }


    public static <T> T parse(InputStream ins, Class<T> clz) {
        try {
            return mapper.readValue(ins, clz);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }


    public static <T> T parse(Reader reader, Class<T> clz) {
        try {
            return mapper.readValue(reader, clz);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static JavaType createCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }


    @SuppressWarnings("unchecked")
    public static <T> T parse(String value, JavaType javaType) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }

        try {
            return (T) mapper.readValue(value, javaType);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T update(String value, T object) {
        try {
            return (T) mapper.readerForUpdating(object).readValue(value);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static String writeValueAsString(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static void writeJson(Object obj, HttpServletResponse resp) {
        try {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("utf8");
            PrintWriter pw = resp.getWriter();
            String str = null;
            if (!(obj instanceof String)) {
                str = toString(obj);
            } else {
                str = obj.toString();
            }
            pw.print(str);
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void write(OutputStream outs, Object o) {
        try {
            mapper.writeValue(outs, o);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static void write(Writer writer, Object o) {
        try {
            mapper.writeValue(writer, o);
            //System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(o)+"===================");
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static void writeWithOnlyYMDDate(Writer writer, Object o) {
        try {
            mapperWithYMDDate.writeValue(writer, o);
            //System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(o)+"===================");
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static String toString(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static byte[] toBytes(Object o) {
        try {
            return mapper.writeValueAsBytes(o);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }


    private static Object getValue(String jsonStr, String key) {
        JSONObject json = null;
        try {
            json = JSON.parseObject(jsonStr);
            return json.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private JSONObject jsonObject;


    public FkJsonUtil addData(String key, Object value) {
        this.jsonObject.put(key, value);
        return this;
    }

    public FkJsonUtil addMessage(Object value) {
        this.jsonObject.put("message", value);
        return this;
    }

    public FkJsonUtil addCode(Object value) {
        this.jsonObject.put("code", value);
        return this;
    }


    public String toJsonString() {
        return this.jsonObject.toJSONString();
    }


    public JSON toJson() {
        return this.jsonObject;
    }
}
