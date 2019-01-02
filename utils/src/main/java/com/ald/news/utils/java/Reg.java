package com.ald.news.utils.java;

import com.ald.news.utils.Constants;
import com.ald.news.utils.common.Gender;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;
import java.util.regex.Pattern;

public class Reg {

    /**
     * 时间转换
     */
    public static Date parseDate(String date) throws ParseException {
        return DateUtils.parseDate(date, Constants.Date.PATTERNS);
    }

    /**
     * 是不是规定格式的时间
     */
    public static boolean isDate(String dateStr, String dayPattern) {
        try {
            DateUtils.parseDate(dateStr, new String[]{dayPattern});
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 是否是整数
     */
    public static boolean isNumber(String num) {
        try {
            Integer.valueOf(num);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 是不是身份证号码
     */
    public static boolean isIdCard(String idCard) {
        if (StringUtil.isEmpty(idCard))
            return false;
        Pattern regForIdCard = Pattern.compile(Constants.Pattern.ID_NUMBER);
        return regForIdCard.matcher(idCard).matches();
    }

    /**
     * 从身份证中提取性别
     */
    public static Gender getGenderFromIdCard(String idCardNo) {
        if (!isIdCard(idCardNo)) {
            return null;
        } else {
            int idx = idCardNo.length() == 18 ? 16 : 14;
            String genderStr = idCardNo.substring(idx, idx + 1);
            return Integer.valueOf(genderStr) % 2 == 0 ? Gender.FAMAIL : Gender.MAIL;
        }
    }

    /**
     * 从身份证中提取出生日月
     */
    public static String getBirthDayFromIdCard(String idCardNo) {
        if (!isIdCard(idCardNo)) {
            return null;
        } else {
            int cutIdx = idCardNo.length() == 18 ? 0 : 2;
            String year = idCardNo.substring(6, 10 - cutIdx);
            String month = idCardNo.substring(10 - cutIdx, 12 - cutIdx);
            String day = idCardNo.substring(12 - cutIdx, 14 - cutIdx);
            return (year.length() == 2 ? "19" + year : year) + "-" + month + "-" + day;
        }


    }

    /**
     * 校验银行卡卡号
     * <pre>
     *       1、从卡号最后一位数字开始，逆向将奇数位(1、3、5等等)相加。
     * 2、从卡号最后一位数字开始，逆向将偶数位数字，先乘以2（如果乘积为两位数，则将其减去9），再求和。
     * 3、将奇数位总和加上偶数位总和，结果应该可以被10整除。
     * </pre>
     */
    public static boolean isBankCard(String bankCard) {
        if (StringUtil.isEmpty(bankCard))
            return false;
        if (bankCard.length() < 15 || bankCard.length() > 19) {
            return false;
        }
        char bit = getBankCardCheckCode(bankCard.substring(0, bankCard.length() - 1));
        if (bit == 'N') {
            return false;
        }
        return bankCard.charAt(bankCard.length() - 1) == bit;
    }

    /**
     * 从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位
     *
     * @param nonCheckCodeBankCard
     * @return
     */
    private static char getBankCardCheckCode(String nonCheckCodeBankCard) {
        if (nonCheckCodeBankCard == null || nonCheckCodeBankCard.trim().length() == 0
                || !nonCheckCodeBankCard.matches("\\d+")) {
            //如果传的不是数据返回N    
            return 'N';
        }
        char[] chs = nonCheckCodeBankCard.trim().toCharArray();
        int luhmSum = 0;
        for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if (j % 2 == 0) {
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhmSum += k;
        }
        return (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
    }
}
