package com.ald.news.utils.java;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * 类DateUtil.java的实现描述：DateUtil
 *
 * @author 陈金虎 2015年12月21日 下午6:24:41
 */
public class DateUtil extends DateUtils {

    /**
     * milliseconds in a second.
     */
    public static final long SECOND = 1000;

    /**
     * milliseconds in a minute.
     */
    public static final long MINUTE = SECOND * 60;

    /**
     * milliseconds in a hour.
     */
    public static final long HOUR = MINUTE * 60;

    /**
     * milliseconds in a day.
     */
    public static final long DAY = 24 * HOUR;

    /**
     * yyyyMMdd
     */
    public static final String DEFAULT_PATTERN = "yyyyMMdd";

    /**
     * yyyy-MM-dd
     */
    public static final String DEFAULT_PATTERN_WITH_HYPHEN = "yyyy-MM-dd";

    /**
     * yyyy-MM
     */
    public static final String MONTH_PATTERN = "yyyy-MM";

    /**
     * yyyy.MM.dd
     */
    public static final String DEFAULT_PATTERN_WITH_DOT = "yyyy.MM.dd";

    /**
     * yyyy年MM月dd
     */
    public static final String DEFAULT_CHINESE_PATTERN = "yyyy年MM月dd";

    /**
     * yyyyMMddHH
     */
    public static final String HOUR_PATTERN = "yyyyMMddHH";

    /**
     * yyyyMMddHHmmss
     */
    public static final String FULL_PATTERN = "yyyyMMddHHmmss";

    /**
     * yyyyMMdd HH:mm:ss
     */
    public static final String FULL_STANDARD_PATTERN = "yyyyMMdd HH:mm:ss";

    /**
     * MM.dd HH:mm
     */
    public static final String FULL_MATCH_PATTERN = "MM.dd HH:mm";

    /**
     * HH:mm
     */
    public static final String SHORT_MATCH_PATTERN = "HH:mm";

    /**
     * yyyy-MM-dd HH:mm
     */
    public static final String DATE_TIME_MINUTE = "yyyy-MM-dd HH:mm";

    /**
     * <pre>
     * yyyy-MM-dd HH:mm:ss
     * </pre>
     */
    public static final String DATE_TIME_SHORT = "yyyy-MM-dd HH:mm:ss";

    /**
     * <pre>
     * yyyy-MM-dd HH:mm:ss.SSS
     * </pre>
     */
    public static final String DATE_TIME_FULL = "yyyy-MM-dd HH:mm:ss";

    public static final String FINAL_END_DATE_STR = "9999-12-30";

    //原始时间
    public static final Date INIT_DATE = new Date(0l);

    public static String format(final Date date) {
        if (null == date) {
            return "";
        }
        return format(date, DEFAULT_PATTERN);
    }

    public static String formatWithDateTimeShort(final Date date) {
        if (date == null) {
            return "";
        }
        return format(date, DATE_TIME_SHORT);
    }

    public static String formatWithDateTimeHyphen(final Date date) {
        if (date == null) {
            return "";
        }
        return format(date, DEFAULT_PATTERN_WITH_HYPHEN);
    }

    public static String format(final Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * Add specified number of days to the given date.
     *
     * @param date date
     * @param days Int number of days to add
     * @return revised date
     */
    public static Date addDays(final Date date, int days) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, days);

        return new Date(cal.getTime().getTime());
    }

    public static Date addMins(final Date date, int mins) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, mins);

        return new Date(cal.getTime().getTime());
    }

    public static Date addSeconds(final Date date, int seconds) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, seconds);

        return new Date(cal.getTime().getTime());
    }

    public static Date parseDate(final String str, final String parsePatterns) {
        if (StringUtils.isBlank(str) || StringUtils.isBlank(parsePatterns)) {
            throw new IllegalArgumentException("Date and Patterns must not be null");
        }
        SimpleDateFormat parser = new SimpleDateFormat(parsePatterns);
        try {
            return parser.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 转换long类型到时,分,秒,毫秒的格式.
     *
     * @param time long type
     * @return
     */
    public static String convert(long time) {
        long ms = time % 1000;
        time /= 1000;

        int h = Integer.valueOf("" + (time / 3600));
        int m = Integer.valueOf("" + ((time - h * 3600) / 60));
        int s = Integer.valueOf("" + (time - h * 3600 - m * 60));

        return h + "小时(H)" + m + "分(M)" + s + "秒(S)" + ms + "毫秒(MS)";
    }

    /**
     * judge the srcDate is between startDate and endDate
     *
     * @param srcDate
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean isBetweenDateRange(final Date srcDate, final Date startDate, final Date endDate) {
        if (srcDate != null && startDate != null && endDate != null) {
            return srcDate.getTime() >= startDate.getTime() && srcDate.getTime() <= endDate.getTime();
        }
        return false;
    }

    /**
     * 获取指定的时间
     *
     * @param dayOffSet
     * @param hourOffSet
     * @param minuteOffSet
     * @param secondsOffSet
     * @return
     */
    public static Date getCertainDate(int dayOffSet, int hourOffSet, int minuteOffSet, int secondsOffSet) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, dayOffSet);
        calendar.set(Calendar.HOUR, hourOffSet);
        calendar.set(Calendar.MINUTE, minuteOffSet);
        calendar.set(Calendar.SECOND, secondsOffSet);
        return calendar.getTime();
    }

    public static Date getCentainOffDate(Date date, int dayOffSet) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, dayOffSet);
        return calendar.getTime();
    }

    /**
     * Get start of date.
     *
     * @param date Date
     * @return Date Date
     */
    public static Date getStartOfDate(final Date date) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return new Date(cal.getTime().getTime());
    }

    /**
     * Get date one day before specified one.
     *
     * @param date1 test date
     * @param date2 date when
     * @return true if date1 is before date2
     */
    public static boolean beforeDay(final Date date1, final Date date2) {
        return getStartOfDate(date1).before(getStartOfDate(date2));
    }

    /**
     * Get date one day after specified one.
     *
     * @param date1 Date 1
     * @param date2 Date 2
     * @return true if date1 after date2
     */
    public static boolean afterDay(final Date date1, final Date date2) {
        return date1.after(date2);
//        return getStartOfDate(date1).after(getStartOfDate(date2));
    }

    /**
     * 一天的结束时间，【注：只精确到毫秒】
     *
     * @param date
     * @return
     */
    public static Date getEndOfDate(final Date date) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);

        return new Date(cal.getTime().getTime());
    }

    /**
     * 一天的结束时间，【注：只精确到秒】
     *
     * @param date
     * @return
     */
    public static Date getEndOfDatePrecisionSecond(final Date date) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 000);

        return new Date(cal.getTime().getTime());
    }

    /**
     * 一天的结束时间的时间戳
     */
    public static long getEndOfDateTimestamp(final Date date) {
        return getEndOfDatePrecisionSecond(new Date()).getTime() / 1000;
    }

    /**
     * 返回当前日
     *
     * @return [dd]
     */

    public static String getDay(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        String pid = formatter.format(date);
        return pid;
    }

    /**
     * 返回当前月份,如果date为null则返回当前月份
     *
     * @return [MM]
     */

    public static String getMonth(Date date) {
        if (date == null) {
            date = new Date();
        }
        SimpleDateFormat formatter = new SimpleDateFormat("MM");
        String pid = formatter.format(date);
        return pid;
    }

    /**
     * 返回当前年份,如果date为null则返回当前年份
     *
     * @return [MM]
     */

    public static String getYear(Date date) {
        if (date == null) {
            date = new Date();
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        String pid = formatter.format(date);
        return pid;
    }

    /**
     * 返回一个Date默认最大值
     *
     * @return
     */
    public static Date getFinalDate() {
        return parseDate(FINAL_END_DATE_STR, DEFAULT_PATTERN_WITH_HYPHEN);
    }

    /**
     * Return the end of the month based on the date passed as input parameter.
     *
     * @param date Date
     * @return Date endOfMonth
     */
    public static Date getEndOfMonth(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
        calendar.set(Calendar.DATE, 0);

        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Date(calendar.getTimeInMillis());
    }

    /**
     * Get first day of month.
     *
     * @param date Date
     * @return Date
     */
    public static Date getFirstOfMonth(final Date date) {
        Date lastMonth = addMonths(date, -1);
        lastMonth = getEndOfMonth(lastMonth);
        return addDays(lastMonth, 1);
    }

    /**
     * Add specified number of months to the date given.
     *
     * @param date   Date
     * @param months Int number of months to add
     * @return Date
     */
    public static Date addMonths(Date date, int months) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
    }

//    /**
//     * @param timeString 年、月、日   eg。“MM”,"YYYY"
//     * @param timeLong   时间搓
//     * @return
//     */
//    public static int getTimeYearOrMonthOrDay(String timeString, long timeLong) {
//        SimpleDateFormat formatter = new SimpleDateFormat(timeString);
//        Date nowc = new Date(timeLong);
//
//        int time = NumberUtil.objToIntDefault(formatter.format(nowc), -1);
//
//        return time;
//    }

    /**
     * 计算2个日前直接相差的天数
     *
     * @param cal1
     * @param cal2
     * @return
     */
    public static long getNumberOfDaysBetween(Calendar cal1, Calendar cal2) {
        cal1.clear(Calendar.MILLISECOND);
        cal1.clear(Calendar.SECOND);
        cal1.clear(Calendar.MINUTE);
        cal1.clear(Calendar.HOUR_OF_DAY);

        cal2.clear(Calendar.MILLISECOND);
        cal2.clear(Calendar.SECOND);
        cal2.clear(Calendar.MINUTE);
        cal2.clear(Calendar.HOUR_OF_DAY);

        long elapsed = cal2.getTime().getTime() - cal1.getTime().getTime();
        return elapsed / DAY;
    }

    public static long getNumberOfDaysBetweenDates(final Date before, final Date end) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(before);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(end);
        return getNumberOfDaysBetween(cal1, cal2);
    }

    /**
     * 返回两个时间间隔的小时数
     *
     * @param before 起始时间
     * @param end    终止时间
     * @return 小时数
     */
    public static long getNumberOfHoursBetween(final Date before, final Date end) {
        long millisec = end.getTime() - before.getTime() + 1;
        return millisec / (60 * 60 * 1000);
    }

    /**
     * 返回两个时间间隔的分钟数
     *
     * @param before 起始时间
     * @param end    终止时间
     * @return 分钟数
     */
    public static long getNumberOfMinuteBetween(final Date before, final Date end) {
        long millisec = end.getTime() - before.getTime();
        return millisec / (60 * 1000);
    }

    public static int getNumberOfMonthsBetween(final Date before, final Date end) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(before);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(end);
        return (cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR)) * 12
                + (cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH));
    }

    public static int getNumberOfSecondsBetween(final double end, final double start) {
        if ((end == 0) || (start == 0)) {
            return -1;
        }

        return (int) (Math.abs(end - start) / SECOND);
    }

    public static Date getNowDate() {
        return new Date();
    }

    /**
     * get date time as "yyyyMMddhhmmss"
     *
     * @return the current date with time component
     */
    public static String getNowYearMonthDay() {
        return format(new Date(), DEFAULT_PATTERN);
    }

    /**
     * get date time as "yyyyMMddhhmmss"
     *
     * @return the current date with time component
     */
    public static String getNowYearMonthDay(Date date) {
        return format(date, DEFAULT_PATTERN);
    }

    /**
     * 根据开始时间和结束时间返回时间段内的时间集合
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static List<Date> getDatesBetweenTwoDate(Date beginDate, Date endDate) {
        List<Date> lDate = new ArrayList<Date>();
        lDate.add(beginDate);// 把开始时间加入集合
        Calendar cal = Calendar.getInstance();
        cal.setTime(beginDate);
        boolean bContinue = true;
        while (bContinue) {
            cal.add(Calendar.DAY_OF_MONTH, 1);
            if (endDate.after(cal.getTime())) {
                lDate.add(cal.getTime());
            } else {
                break;
            }
        }
        lDate.add(endDate);// 把结束时间加入集合
        return lDate;
    }

    public static void main(String[] args) {
        Date now = new Date();
        Date arrivalEnd = DateUtil.getEndOfDate(now);
        Integer day = 7;
        Date repaymentDay = DateUtil.addDays(arrivalEnd, day - 1);
        System.out.println(repaymentDay);
    }
}
