package com.ald.news.utils.encrypt;

import com.ald.news.utils.java.StringUtil;

import org.apache.commons.lang3.StringUtils;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Author 罗浩
 * @Date 10:26 2017-08-13
 * @Decription
 */
public class UrlCoder {
    /**
     * @param sStr
     * @return
     * @Title: UrlEncoder
     * @Description: 字符串编码
     */
    public final static String UrlEncoder(String sStr) {
        String sReturnCode = "";
        try {
            sReturnCode = URLEncoder.encode(StringUtil.null2Str(sStr), "utf-8");
        } catch (Exception ex) {
        }
        return sReturnCode;
    }

    /**
     * @param sStr
     * @return
     * @Title: UrlDecoder
     * @Description: 字符串解码
     */
    public static String UrlDecoder(String sStr) {
        if (StringUtils.isEmpty(sStr)) {
            return "";
        } else {
            String sReturnCode = sStr;
            try {
                sReturnCode = URLDecoder.decode(sStr, "utf-8");
            } catch (Exception e) {
            }
            return sReturnCode;
        }
    }
}
