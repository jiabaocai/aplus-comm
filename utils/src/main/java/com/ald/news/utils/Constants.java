package com.ald.news.utils;

/**
 * todo 各负责人员, 严格按照格式书写配置类, 以token为准, 必须说明用途, 使用静态内部类的方式, 其他地方不允许定义, 且每个静态类指责
 */
public class Constants {

    /**
     * 全局公用属性
     */
    public static final class Global {

        /**
         * 默认分隔符, 逗号
         */
        public static final String SPLIT = ",";


        /**
         * session用户实体键
         */
        public static final String SYSUSER = "SysUser";

        /**
         * 默认缓存区大小, 单位字节
         */
        public static int DEFAULT_BUFFER_LENGTH = 8 * 1024;

        /**
         * 操作成功
         */
        public static final String OPERATION_SUCCESS = "操作成功";

        /**
         * 操作失败
         */
        public static final String OPERATION_FAIL = "操作失败";

        /**
         * 响应code
         */
        public static final String RESPONSE_CODE = "code";

        /**
         * 响应msg键
         */
        public static final String RESPONSE_CODE_MSG = "msg";

        /**
         * 响应data键
         */
        public static final String RESPONSE_DATA = "data";

        /**
         * 全局默认字符集
         */
        public static final String CHARSET_UTF8 = "utf-8";

        /**
         * http交互方式
         */
        public static final String APPLICATION_JSON = "application/json";

        /**
         * rest接口返回定义
         */
        public static final String PRODUCES = APPLICATION_JSON + ";charset=" + CHARSET_UTF8;

        /**
         * 插入数据时用于对比
         */
        public static final String INSERT = "create";

        /**
         * 修改数据时用于对比
         */
        public static final String UPDATE = "update";

        public static final String RESPONSE_DATA_TOTAL = "total";

        public static final String RESPONSE_DATA_TOTALCOUNT = "totalCount";

        public static final String RESPONSE_DATA_CURRENTPAGE = "currentPage";

        public static final String RESPONSE_DATA_PAGE = "page";

        public static final int SUCCEED_CODE_VALUE = 200; // 成功 插入 、删除 更新 修改

        public static final int FAIL_CODE_VALUE = 400; // 失败 插入 、删除 更新 修改

        public static final String RESPONSE_MSG = "登陆状态";

        public static final String SESSION_SYSUSER = "SysUser";

    }

    /**
     * 用户相关设置
     */
    public static final class User {
        /**
         * 响应登录校验结果-登录成功
         */
        public static final String USER_LOGIN_SUCCESS = "登录成功";
        /**
         * 响应登录校验结果-登录失败(未知异常时使用)
         */
        public static final String USER_LOGIN_FAIL = "登录失败";
        /**
         * 响应登录校验结果-验证码过期
         */
        public static final String VERIFICATIONCODE_EXPIRE = "验证码过期,请重新获取";
        /**
         * 响应登录校验结果-验证码不正确
         */
        public static final String VERIFICATIONCODE_INCORRECT = "验证码不正确";
        /**
         * 响应编辑个人资料-保存成功
         */
        public static final String USER_SAVE_SUCCESS = "保存成功";
        /**
         * 响应编辑个人资料-保存失败
         */
        public static final String USER_SAVE_FAIL = "保存失败";
        /**
         * 本地登录用户默认昵称前缀
         */
        public static final String USER_NICKNAME_PREFIX = "edsnews";
        /**
         * 本地登录用户默认昵称后缀数字位数
         */
        public static final int USER_NICKNAME_LENGTH = 6;
        /**
         * 设置用户UUID长度
         */
        public static final int USER_UUID_LENGTH = 16;
    }

    /**
     * Redis相关设置
     */
    public static final class Redis {
        /**
         * 后台存储到Redis的key共同前缀
         */
        public static final String KEY_PREFIX = "server:";
        /**
         * 后台存储到Redis的手机号码前缀
         */
        public static final String KEY_MOBILE = "mobile:";
        /**
         * 后台存储到Redis的短信验证码前缀
         */
        public static final String KEY_SMS = "sms:";
        /**
         * 后台存储到Redis的用户UUID前缀
         */
        public static final String KEY_UUID = "uuid:";
        /**
         * 后台存储到Redis的用户昵称前缀
         */
        public static final String KEY_NICKNAME = "nickname:";
        /**
         * 存储redis控制间隔业务频率字段
         */
        public static final String KEY_BUSY = "busy";
        /**
         * 存储redis控制每天业务频率字段
         */
        public static final String KEY_SEND_COUNT = "send_count";
        /**
         * 存储redis控制短信发送频率,60s
         */
        public static final int SMS_TIMEOUT = 60;
        /**
         * 存储redis控制每天每个手机能发送的次数
         */
        public static final String SMS_DAY_COUNT = "10";
    }

    /**
     * 短信相关设置
     */
    public static final class SMS {
        /**
         * 响应校验手机或验证码
         */
        public static final String MOBILE_OR_CODE_INCORRECT = "手机或验证码位数不对";
        /**
         * 响应校验手机格式校验未通过提示
         */
        public static final String MOBILE_FORMAT_INCORRECT = "手机号码格式不正确";
        /**
         * 短信发送成功
         */
        public static final String SEND_SMS_SUCCESS = "短信发送成功";
        /**
         * 短信发送失败
         */
        public static final String SEND_SMS_FAIL = "短信发送失败";
        /**
         * 设置短信验证码过期时间,单位为分钟
         */
        public static final int SMS_VERIFICATIONCODE_OVERTIME = 30;
        /**
         * 设置短信验证码长度,至少4位
         */
        public static final int SMS_CODE_LENGTH = 6;
        /**
         * redis存储的手机key
         */
        public static final String SMS_MOBILE = "mobile";
        /**
         * redis存储的验证码key
         */
        public static final String SMS_VERIFICATIONCODE = "verificationCode";
    }

    /**
     * 新闻状态
     */
    public static final class News {
        /**
         * 新闻状态-已收藏
         */
        public static final Byte NEWS_COLLECT_CONFIRM = 1;
        /**
         * 新闻状态-取消收藏
         */
        public static final Byte NEWS_COLLECT_CANCEL = 2;
    }
    /**
     * 搜索接口
     */
    public static final class SearchConstans {
        /**
         * 搜索类型 1 标题搜索
         */
        public static final int SEARCH_TYPE_TITLE = 1;
        /**
         * 搜索类型 2 标签搜索
         */
        public static final int SEARCH_TYPE_LABEL = 2;
    }

    /**
     * token方面设置
     */
    public static final class Token {

        /**
         * token在请求头中的键
         */
        public static final String KEY = "token";

        /**
         * token的加密密钥
         */
        public static final String SECRET = "0123456789";

        /**
         * token场景
         */
        public static final String SUBJECT = "aladin";

        /**
         * token中包含的用户编号
         */
        public static final String USER_ID = "userId";

    }

    /**
     * 加解密属性
     */
    public static final class Encrypt {

        /**
         * SHA-1算法
         */
        public static final String SHA_1 = "SHA-1";

        /**
         * 加密salt值
         */
        public static final String SALT = "rongdumlms";

    }

    /**
     * 时间常量
     */
    public static final class Date {
        /**
         * 时间表达式集合
         */
        public static final String[] PATTERNS = {"yyyyMMdd", "yyyy-MM-dd", "yyyy/MM/dd", "yyyy年MM月dd日",
                "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss", "yyyy年MM月dd日 HH时mm分ss秒", "yyyy年MM月dd日 HH:mm:ss"};

        /**
         * 默认时间表达式(到天)
         */
        public static final String DEFAULT_DAY_NO_HOUR_PATTERN = "yyyy-MM-dd";
        /**
         * 默认时间表达式
         */
        public static final String DEFAULT_DAY_PATTERN = "yyyy-MM-dd HH:mm:ss";

        /**
         * 默认时间戳表达式
         */
        public static final String DEFAULT_TIME_STAMP = "yyyyMMddHHmmssSSS";

    }

    /**
     * 正则表达式
     */
    public static final class Pattern {
        /**
         * 身份证正则表达式
         */
        public static final String ID_NUMBER = "(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}[0-9Xx]$)";

        public static final String MAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    }

    /**
     * 响应状态码
     */
    public static final class ResponseCode {

        /**
         * 成功 插入 、删除 更新 修改
         */
        public static final int SUCCEED_CODE_VALUE = 200;

        /**
         * 参数列表不完整
         */
        public static final int FAIL_CODE_PARAM_INSUFFICIENT = 300;

        /**
         * 失败 插入 、删除 更新 修改
         */
        public static final int FAIL_CODE_VALUE = 400;

        /**
         * 无权限访问
         */
        public static final int PERM_CODE_VALUE = 403;

        /**
         * 其他异常
         */
        public static final int OTHER_CODE_VALUE = 500;

        /**
         * 连接超时
         */
        public static final int SESSION_CODE_VALUE = 600;

        /**
         * 未登陆
         */
        public static final int NO_LOGIN_CODE_VALUE = 601;

        /**
         * 连接异常（除请求超时）
         */
        public static final int CLIENT_EXCEPTION_CODE_VALUE = 998;

        /**
         * 请求超时
         */
        public static final int TIMEOUT_CODE_VALUE = 999;

        /**
         * 验签失败
         */
        public static final int SIGN_FAIL = 99;
    }

    /**
     * 新闻热度
     */
    public static final class Score{
        /**
         * 点赞
         */
        public static final String LIKE ="0";

        /**
         * 取消点赞
         */
        public static final String  CANCEL_LIKE="1";

        /**
         * 点赞分
         */
        public static final int LIKE_SCORE =500;

        /**
         * 收藏
         */
        public static final String COLLECTION ="2";

        /**
         * 取消收藏
         */
        public static final String CANCEL_COLLECTION ="3";

        /**
         * 收藏分
         */
        public static final int COLLECTION_SCORE =700;

        /**
         * 转发
         */
        public static final String FORWARD ="4";
        /**
         * 转发分
         */
        public static final int FORWARD_SCORE =1000;

        /**
         * 举报
         */
        public static final String REPORT ="5";

        /**
         * 举报分
         */
        public static final int REPORT_SCORE =500;

        /**
         * 屏蔽
         */
        public static final String SHIELD ="6";

        /**
         * 屏蔽分
         */
        public static final int SHIELD_SCORE =1000;
    }

}
