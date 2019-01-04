package com.ald.aplus.thirdparty.service;

import com.ald.news.core.base.BaseResponse;

import java.util.Map;

/**
 * @program: aplus
 * @Version 1.0.0
 * @description:
 * @author: Mr.cai
 * @create: 2019-01-04 11:21
 * @CopyRight 本内容仅限于北境内部传阅，禁止外泄以及用于其他的商业目的
 **/
public interface YopClientService {
    BaseResponse yopApi(Map<String, Object> params, String urlType);
}


 
