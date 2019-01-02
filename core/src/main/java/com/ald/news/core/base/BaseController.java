package com.ald.news.core.base;

import com.ald.news.utils.app.FkJsonUtil;
import com.ald.news.utils.java.DateUtil;
import com.alibaba.fastjson.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 定义控制器公共方法和属性
 * @author xdj
 */
@Component
public class BaseController extends ApplicationObjectSupport {

    protected static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;
    private static final String CONTENT_TYPE = "content-type";
    public static final String JS_TYPE = "text/javascript";
    public static final String CODE_UTF8 = "UTF-8";

    public static void writeToResponse(HttpServletResponse response,
                                       Map<? extends Object, Object> res) {
        response.addHeader(CONTENT_TYPE, JS_TYPE);

        response.setContentType("application/json");
        response.setCharacterEncoding(CODE_UTF8);
        OutputStreamWriter out = null;
        try {
            out = new OutputStreamWriter(
                    response.getOutputStream(), CODE_UTF8);
        } catch (UnsupportedEncodingException e) {
            logger.error("系统出错：" + e.getMessage());
        } catch (IOException e) {
            logger.error("系统出错：" + e.getMessage());
        }
        FkJsonUtil.write(out, res);
    }

    public static void writeToResponseWithOnlyYMDDate(HttpServletResponse response,
                                                      Map<? extends Object, Object> res) {
        response.addHeader(CONTENT_TYPE, JS_TYPE);

        response.setContentType("application/json");
        response.setCharacterEncoding(CODE_UTF8);
        OutputStreamWriter out = null;
        try {
            out = new OutputStreamWriter(
                    response.getOutputStream(), CODE_UTF8);
        } catch (UnsupportedEncodingException e) {
            logger.error("系统出错：" + e.getMessage());
        } catch (IOException e) {
            logger.error("系统出错：" + e.getMessage());
        }
        FkJsonUtil.writeWithOnlyYMDDate(out, res);
    }

    public static void writeToResponselist(HttpServletResponse response,
                                           List<? extends Object> res) throws IOException {
        response.addHeader(CONTENT_TYPE, JS_TYPE);
        OutputStreamWriter out = new OutputStreamWriter(
                response.getOutputStream(), CODE_UTF8);
        FkJsonUtil.write(out, res);
    }

    public static void writeToResponselist2(HttpServletResponse response,
                                            List<Object> res) throws IOException {
        response.addHeader(CONTENT_TYPE, JS_TYPE);
        OutputStreamWriter out = new OutputStreamWriter(
                response.getOutputStream(), CODE_UTF8);
        FkJsonUtil.write(out, res);
    }

    public static void writeToResponse(HttpServletResponse response,
                                       Object object) throws UnsupportedEncodingException, IOException {
        response.addHeader(CONTENT_TYPE, JS_TYPE);
        response.setContentType("application/json");
        response.setCharacterEncoding(CODE_UTF8);

        OutputStreamWriter out = new OutputStreamWriter(
                response.getOutputStream(), CODE_UTF8);

        FkJsonUtil.write(out, object);
    }


    public String parseJSONParam(JSONObject json) {
        if (json == null) {
            return StringUtils.EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        if (json.getLong("gmtStart") != null) {
            json.put("gmtStart", DateUtil.formatWithDateTimeShort(new Date(json.getLong("gmtStart"))));
        }
        if (json.getLong("gmtEnd") != null) {
            json.put("gmtEnd", DateUtil.formatWithDateTimeShort(new Date(json.getLong("gmtEnd"))));
        }
        for (String key : json.keySet()) {
            sb.append("&").append(key).append("=").append(json.get(key));
        }
        return sb.toString().replaceFirst("&", "");
    }

    public Object invokeValue(String beanName, String methodName) throws Exception {
        return invokeValue(beanName, methodName, null, null);
    }

    public Object invokeValue(String beanName, String methodName, Class<?>[] classArray, Object[] paramArray)
            throws Exception {
        Object clazz = this.getApplicationContext().getBean(beanName);
        if (clazz == null) {
            logger.info("clazz is null");
            return null;
        }
        Class<?> clz = clazz.getClass();
        Method method = clz.getMethod(methodName, classArray);
        return method.invoke(clazz, paramArray);
    }

}