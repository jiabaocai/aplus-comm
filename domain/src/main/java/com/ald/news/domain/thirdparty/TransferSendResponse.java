package com.ald.news.domain.thirdparty;

import lombok.Data;

/**
 * @program: aplus
 * @Version 1.0.0
 * @description: 代付单笔出款接口返回参数
 * @author: Mr.cai
 * @create: 2019-01-04 14:05
 * @CopyRight 本内容仅限于北境内部传阅，禁止外泄以及用于其他的商业目的
 **/
@Data
public class TransferSendResponse {
    /**
     * 返回码
     */
    private String errorCode;
    /**
     * 返回描述信息
     */
    private String errorMsg;
    /**
     * 出款订单号
     */
    private String orderId;
    /**
     * 出款批次号
     */
    private String batchNo;
    /**
     * 出款状态编码
     */
    private String transferStatusCode;
}


 
