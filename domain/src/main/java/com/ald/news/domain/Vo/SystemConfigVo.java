package com.ald.news.domain.Vo;

import java.io.Serializable;

/**
 * Created by luohao on 2017/8/25.
 */
public class SystemConfigVo implements Serializable {
    private String name;
    private Integer type;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
