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
//    BaseResponse transfer_send(Map<String, Object> params);
    BaseResponse yopApi(Map<String, Object> params,String urlType);
//
//
//    BaseResponse transfer_batch_send(Map<String, Object> params);
//
//    BaseResponse transfer_query(Map<String, Object> params);
//
//    BaseResponse query_customer_amount(Map<String, Object> params);
}


 