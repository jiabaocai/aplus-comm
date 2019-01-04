package com.ald.news.domain.thirdparty;

import lombok.Data;

/**
 * @program: aplus
 * @Version 1.0.0
 * @description:  代付单笔出款接口请求参数
 * @author: Mr.cai
 * @create: 2019-01-04 13:53
 * @CopyRight 本内容仅限于北境内部传阅，禁止外泄以及用于其他的商业目的
 **/
@Data
public class TransferSendRequest {
    /**
     * 商户编号
     */
    private String customerNumber;
    /**
     * 集团商户编号
     */
    private String groupNumber;
    /**
     * 出款批次号
     */
    private String batchNo;
    /**
     * 出款订单号
     */
    private String orderId;
    /**
     * 出款金额
     */
    private String amount;
    /**
     * 出款产品类型
     */
    private String product;
    /**
     * 是否加急
     */
    private String urgency;
    /**
     * 收款银行账户名称
     */
    private String accountName;
    /**
     * 收款银行账户卡号
     */
    private String accountNumber;
    /**
     * 收款银行编号
     */
    private String bankCode;
    /**
     * 收款银行全称
     */
    private String bankName;
    /**
     * 收款银行支行名称
     */
    private String bankBranchName;
    /**
     * 收款银行省编码
     */
    private String provinceCode;
    /**
     * 收款银行城市编码
     */
    private String cityCode;
    /**
     * 手续费方式
     */
    private String feeType;
    /**
     * 描述
     */
    private String desc;
    /**
     * 留言
     */
    private String leaveWord;
    /**
     * 摘要
     */
    private String abstractInfo;
}


 
