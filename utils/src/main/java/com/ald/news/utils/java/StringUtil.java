/*
 * Copyright (c) 2016,浙江阿拉丁电子商务股份有限公司 All Rights Reserved.
 */
package com.ald.news.utils.java;

import com.ald.news.utils.Constants;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    private static final String COMMA = ",";

    /**
     * unicode 0x0020
     */
    public static final char SpaceCharA = ' ';

    /**
     * unicode 0x3000
     */
    // public static final char SpaceCharB = ' ';
    // public static final char SpaceCharB = (char)12288;
    public static final char SpaceCharB = (char) Integer.valueOf("3000", 16).intValue();

    /**
     * unicode 0xe525
     */
    // public static final char SpaceCharC = '';
    // public static final char SpaceCharC = (char)58661;
    public static final char SpaceCharC = (char) Integer.valueOf("e525", 16).intValue();

    /**
     * unicode 0xe5f1
     */
    // public static final char SpaceCharD = '';
    // public static final char SpaceCharD = (char)58865;
    public static final char SpaceCharD = (char) Integer.valueOf("e5f1", 16).intValue();

    /**
     * String of unicode char 0x0020
     */
    public static final String SpaceStringA = String.valueOf(SpaceCharA);

    /**
     * String of unicode char 0x3000
     */
    public static final String SpaceStringB = String.valueOf(SpaceCharB);

    /**
     * String of unicode char 0xe525
     */
    public static final String SpaceStringC = String.valueOf(SpaceCharC);

    /**
     * String of unicode char 0xe5f1
     */
    public static final String SpaceStringD = String.valueOf(SpaceCharD);

    /**
     * @see
     */
    private final static Character.UnicodeBlock chinese = Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS;

    /**
     * 判断一个字符串是否包含中文
     *
     * @param str
     * @return
     */
    public static boolean containChinese(String str) {
        if (null == str || str.isEmpty()) {
            return false;
        }
        char[] chars = str.toCharArray();
        for (char c : chars) {
            boolean isChinese = isChinese(c);
            if (isChinese) {
                return true;
            }
        }
        return false;
    }

    /**
     * 是否包含字母
     *
     * @param str
     * @return
     */
    public static boolean containLetter(String str) {
        if (null == str || str.isEmpty()) {
            return false;
        }
        char[] chars = str.toCharArray();
        for (char c : chars) {
            boolean isLetter = isLetter(c);
            if (isLetter) {
                return true;
            }
        }
        return false;
    }

    public static String toString(Collection list) {
        return toString(list, Constants.Global.SPLIT);
    }

    public static String toString(Collection list, String delim) {
        StringBuilder sb = new StringBuilder();
        int index = 0;

        for (Object o : list) {
            if (index > 0) sb.append(delim);
            sb.append(o.toString());
            index++;
        }
        return sb.toString();
    }

    public static String toString(String separate, int... objs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objs.length; i++) {
            if (i > 0) sb.append(separate);
            sb.append(objs[i]);
        }
        return sb.toString();
    }

    /**
     * 判断输入的手机号码是否有效
     *
     * @param str 手机号码
     * @return 检验结果（true：有效 false：无效）
     */
    public static boolean isPhone(String str) {
        String phone = "";
        if (phone != null && !phone.equals("")) {
            phone = str;
        }
        Pattern regex = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
        Matcher matcher = regex.matcher(phone);
        boolean isMatched = matcher.matches();
        return isMatched;
    }

//    /**
//     * 判断邮箱是否有效
//     *
//     * @param str 邮箱
//     * @return 检验结果（true：有效 false：无效）
//     */
//    public static boolean isMail(String str) {
//        String mail = isNull(str);
//        Pattern regex = Pattern.compile(Constants.Pattern.MAIL);
//        Matcher matcher = regex.matcher(mail);
//        boolean isMatched = matcher.matches();
//        return isMatched;
//    }

    /**
     * 是不是身份证号码
     */
    public static boolean isCard(String idCard) {
        if (StringUtil.isEmpty(idCard))
            return false;
        Pattern regForIdCard = Pattern.compile(Constants.Pattern.ID_NUMBER);
        return regForIdCard.matcher(idCard).matches();
    }

    /**
     * 判断一个字符串是否包含字母（大写或小写）
     *
     * @param str
     * @return
     */
    public static boolean containLowerOrUpperCase(String str) {
        if (null == str || str.isEmpty()) {
            return false;
        }
        char[] chars = str.toCharArray();
        for (char c : chars) {
            boolean isLowOrUpperCase = isLowerOrUpperCase(c);
            if (isLowOrUpperCase) {
                return true;
            }
        }
        return false;
    }

    /**
     * 随机生成固定长度的字符串
     *
     * @param length
     * @return String
     */
    public static String getRandomString(int length) { // length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 判断一个char是否为中文。
     *
     * @param c 字符
     * @return 是否为中文
     */
    public static boolean isChinese(char c) {
        return (chinese == Character.UnicodeBlock.of(c));
    }

    /**
     * 检查字符串是否为<code>null</code>或空字符串<code>""</code>。
     * <pre>
     * StringUtil.isEmpty(null) = true
     * StringUtil.isEmpty("") = true
     * StringUtil.isEmpty(" ") = false
     * StringUtil.isEmpty("bob") = false
     * StringUtil.isEmpty("  bob  ") = false
     * </pre>
     *
     * @param str 要检查的字符串
     * @return 如果为空, 则返回<code>true</code>
     */
    public static boolean isEmpty(String str) {
        return ((str == null) || (str.length() == 0));
    }

    /**
     * 判断字符串数组中是否包含某字符串
     *
     * @param right
     * @param needle
     * @return
     */
    public static Boolean isHave(String right, String needle) {
        if (right == null || needle == null) return false;
        String[] source = right.split(";");
        for (String s : source) {
            if (s.equals(needle)) return true;
        }
        return false;
    }

    /**
     * 是否字母
     *
     * @param c
     * @return
     */
    public static boolean isLetter(char c) {
        return Character.isLetter(c);
    }

    /**
     * 是否小写字母
     *
     * @param c
     * @return
     */
    public static boolean isLowerCase(char c) {
        return Character.isLowerCase(c);
    }

    /**
     * 是否英文字母（大写或小写）
     *
     * @param c
     * @return
     */
    public static boolean isLowerOrUpperCase(char c) {
        return Character.isLowerCase(c) || Character.isUpperCase(c);
    }

    /**
     * 是否大写字母
     *
     * @param c
     * @return
     */
    public static boolean isUpperCase(char c) {
        return Character.isUpperCase(c);
    }

    /**
     * 仅仅大写第一个字母
     *
     * @param str
     * @return
     */
    public static String upperCaseFirstLetterOnly(String str) {
        if (null == str || str.length() <= 0) {
            return str;
        }

        StringBuilder buf = new StringBuilder(str.length());

        char[] array = str.toCharArray();

        buf.append(String.valueOf(array[0]).toUpperCase());

        for (int i = 1; i < array.length; i++) {
            buf.append(array[i]);
        }

        return buf.toString();
    }

    /**
     * 大写第一个字母小写其他字母
     *
     * @param str
     * @return
     */
    public static String upperCaseFirstLetterOtherLowerCase(String str) {
        if (null == str || str.length() <= 0) {
            return str;
        }

        StringBuilder buf = new StringBuilder(str.length());

        char[] array = str.toCharArray();

        buf.append(String.valueOf(array[0]).toUpperCase());

        for (int i = 1; i < array.length; i++) {
            buf.append(String.valueOf(array[i]).toLowerCase());
        }

        return buf.toString();
    }

    /**
     * 相同字符的个数
     *
     * @param src
     * @param dst
     * @return
     */
    public static int repeatCharNum(String src, String dst) {
        int num = 0;
        if (StringUtil.isEmpty(src) || StringUtil.isEmpty(dst)) return num;
        src = src.replace(" ", "");
        for (int i = 0; i < src.length(); i++) {
            if (dst.indexOf(src.charAt(i)) != -1) num++;
        }
        return num;
    }

    /**
     * 按pattern模板替换paras参数
     *
     * @param pattern
     * @param paras
     * @return
     */
    public static String format(String pattern, Object... paras) {
        if (null == pattern && null == paras) {
            return pattern;
        }
        if (null == pattern) {
            StringBuffer buf = new StringBuffer();
            for (Object obj : paras) {
                buf.append(obj);
            }
            return buf.toString();
        }
        int count = 0;
        while (pattern.contains("{}")) {
            if (paras.length <= count) {
                break;
            }
            pattern = pattern.replaceFirst("\\{\\}", paras[count++].toString());
        }
        return pattern;
    }

    public static String null2Str(Object str) {
        return (str != null) ? str.toString() : "";
    }

    public static Long null2Long(Object str) {
        try {
            return Long.valueOf(str.toString());
        } catch (Exception e) {
            return 0L;
        }
    }

    public static Integer null2Integer(Object str) {
        try {
            return Integer.valueOf(str.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    // 使用STRING BUFFER 来组装字符串，效率更高
    public static String appendStrs(Object... strings) {
        StringBuffer sb = new StringBuffer();
        for (Object str : strings) {
            sb.append(null2Str(str));
        }
        return sb.toString();
    }

    public static boolean isBlank(String str) {
        int length;

        if ((str == null) || ((length = str.length()) == 0)) {
            return true;
        }

        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static String[] split(String source, String sep) {
        if (isBlank(source)) {
            return null;
        }
        return source.split(sep);
    }

    public static List<String> splitToList(String source, String sep) {
        List<String> result = new ArrayList<String>();
        if (isBlank(source)) {
            return result;
        }
        String[] tempResult = source.split(sep);
        for (String item : tempResult) {
            result.add(item);
        }
        return result;
    }

    public static String strToSecret(String str, int left, int right) {
        StringBuffer sb = new StringBuffer();
        int len = str.length() - left - right;
        if (len > 0) {
            sb.append(str.substring(0, left));
            for (int i = 0; i < len; i++) {
                sb.append("*");
            }
            sb.append(str.substring(str.length() - right));
        } else {
            return str;
        }
        return sb.toString();
    }

    public static String strToSub(String str, int start, int end) {
        int len = str.length() - end;
        if (len > 0 && start >= 0 && end >= 0) {
            str = str.substring(start, end);
        } else {
            return str;
        }
        return str;
    }

    public static String strToSub(String str, int start) {
        int len = str.length() - start;
        if (len > 0 && start >= 0) {
            str = str.substring(start);
        } else {
            return str;
        }
        return str;
    }

    /**
     * 判断某个参数是否在指定范围内
     *
     * @param des         需要判断的参数
     * @param assertRange 参数值的范围
     * @return
     */
    public static boolean assertParam(String des, String... assertRange) {
        if (des == null) {
            return false;
        }
        for (String item : assertRange) {
            if (des.equals(item)) {
                return true;
            }
        }
        return false;
    }

//    /**
//     * 返回非null字符串
//     *
//     * @param str
//     * @return
//     */
//    public static String getNotNullString(String str) {
//        return StringUtil.isNotEmpty(str) ? str : StringUtil.EMPTY;
//    }

    /**
     * 把字符串数组按分隔符转化成字符串
     *
     * @param strArr    字符串数组
     * @param separator 分隔符
     * @return
     */
    public static String turnArrayToStr(String separator, String... strArr) {
        String result = "";
        if (strArr == null || strArr.length < 1) {
            return result;
        }
        if (separator == null) {
            separator = ",";
        }

        for (String item : strArr) {
            result = result + separator + item;
        }
        return result.substring(separator.length());
    }

    /**
     * 把list按分隔符转换成字符串
     *
     * @param strList   list数据
     * @param separator 分隔符
     * @return
     */
    public static String turnListToStr(Collection<String> strList, String separator) {
        String result = "";
        if (strList == null || strList.size() < 1) {
            return result;
        }
        if (separator == null) {
            separator = ",";
        }

        for (String item : strList) {
            result = result + separator + item;
        }
        return result.substring(separator.length());
    }

//    /**
//     * 把List拼接成String 并且添加分隔符
//     *
//     * @param <T>
//     * @param
//     * @return
//     */
//    public static <T> String turnListToStr(List<T> list) {
//        String result = StringUtil.EMPTY;
//        if (CollectionUtils.isEmpty(list)) {
//            return StringUtil.EMPTY;
//        }
//        for (T item : list) {
//            result = result + item + COMMA;
//        }
//        return result.substring(0, result.length() - 1);
//    }
//
//    public static boolean isNotBlank(String str) {
//        return !StringUtil.isBlank(str);
//    }
//
//    public static String dealWithInterestFreeRuleJson(String json) {
//        if (StringUtil.isBlank(json)) {
//            return StringUtil.EMPTY;
//        }
//        StringBuilder sb = new StringBuilder();
//        JSONArray array = JSONObject.parseArray(json);
//        for (int i = 0; i < array.size(); i++) {
//            JSONObject obj = array.getJSONObject(i);
//            sb.append(obj.get("nper")).append("期").append("(").append(obj.get("freeNper")).append(");");
//        }
//        return sb.toString();
//    }

    /**
     * 产生对应位数的随机码,目前限制为数字(用户昵称使用)
     *
     * @param codeLength 随机数字码长度 最少2位
     * @return 数字码字符串
     */
    public static String createRandomCode(int codeLength) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < (codeLength > 2 ? codeLength : 2); i++) {
            stringBuilder.append((int) (Math.random() * 10));
        }
        return stringBuilder.toString();
    }
}
