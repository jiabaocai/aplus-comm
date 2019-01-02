package com.ald.news.user.util;

import com.ald.news.utils.java.StringUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 手机号码格式校验工具类
 *
 * @author xuxm
 */
public class MobileRegexUtil {

    /**
     * 校验手机合法性
     * 规则:手机前三位如下,在加上8位任意数字
     * 130到139
     * 150到159,154除外
     * 180到189
     * 170到179
     * 147
     *
     * @param mobile 手机号码
     * @return 合法返回true, 不合法返回false
     */
    public static boolean isMobileNumber(String mobile) {
        if (StringUtil.isEmpty(mobile)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^((13[0-9])|(15[^4])|(18[0-9])|(17[0-9])|(147))\\d{8}$");
        Matcher matcher = pattern.matcher(mobile);
        return matcher.matches();
    }
}