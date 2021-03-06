package com.ald.news.utils.java;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @Author: zhangzhou
 * @Description:
 * @Date by ${Time} on 2017/12/25
 * @Modifide By:
 */
public class NumberUtil {

    public NumberUtil() {
    }

    public static double format(double d, String format) {
        DecimalFormat df = new DecimalFormat(format);
        String ds = df.format(d);
        return Double.parseDouble(ds);
    }


    public static int compare(double x, double y) {
        BigDecimal val1 = new BigDecimal(x);
        BigDecimal val2 = new BigDecimal(y);
        return val1.compareTo(val2);
    }

    public static double ceil(double d, int len) {
        String str = Double.toString(d);
        int a = str.indexOf(".");
        if (a + 3 > str.length()) {
            a = str.length();
        } else {
            a += 3;
        }

        str = str.substring(0, a);
        return Double.parseDouble(str);
    }

    public static double ceil(double d) {
        return ceil(d, 2);
    }

    public static String format(double d) {
        if (d < 1.0E7D) {
            return d + "";
        } else {
            NumberFormat nf = NumberFormat.getInstance();
            nf.setGroupingUsed(false);
            return nf.format(d);
        }
    }

    public static long getLong(String str) {
        if (StringUtil.isBlank(str)) {
            return 0L;
        } else {
            long ret = 0L;

            try {
                ret = Long.parseLong(str);
            } catch (NumberFormatException var4) {
                ret = 0L;
            }

            return ret;
        }
    }

    public static int getInt(String str) {
        if (StringUtil.isBlank(str)) {
            return 0;
        } else {
            boolean ret = false;

            int ret1;
            try {
                ret1 = Integer.parseInt(str);
            } catch (NumberFormatException var3) {
                ret1 = 0;
            }

            return ret1;
        }
    }

    public static double getDouble(String str) {
        if (StringUtil.isBlank(str)) {
            return 0.0D;
        } else {
            double ret = 0.0D;

            try {
                ret = Double.parseDouble(str);
            } catch (Exception var4) {
                ret = 0.0D;
            }

            return ret;
        }
    }
}
