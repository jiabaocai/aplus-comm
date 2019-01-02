package com.ald.news.utils.common;

/***
 *
 * @author 罗浩
 * @version 1.0.0
 * @date 2017年7月27日 上午10:33:50
 * @description: 性别枚举 参照GB2261性别国家标准
 * 未经授权不得进行修改、复制、出售及商业使用
 *
 */
public enum Gender {

    //未知的性别
    UNKNOW("U", 0),
    //男性
    MAIL("M", 1),
    //女性
    FAMAIL("F", 2),
    //女性改（变）为男性
    FAMAIL_TO_MAIL("FTM", 5),
    //男性改（变）为女性
    MAIL_TO_FAMAIL("MTF", 6),
    //未说明的性别
    NOT_DECLARE("ND", 9);

    private String codeStr;
    private Integer codeInt;

    Gender(String codeStr, Integer codeint) {
        this.codeStr = codeStr;
        this.codeInt = codeint;
    }

    public String getCode() {
        return codeStr;
    }

    public Integer getCodeInt() {
        return codeInt;
    }


}
