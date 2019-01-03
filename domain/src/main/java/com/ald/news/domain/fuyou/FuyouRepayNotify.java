package com.ald.news.domain.fuyou;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;

@Table(name = "fuyou_repay_notify")
public class FuyouRepayNotify {
    /**
     * id
     */
    @ApiModelProperty("id")
    private Long id;

    /**
     * 版本号
     */
    @ApiModelProperty("版本号")
    private String version;

    /**
     * 类型
     */
    @ApiModelProperty("类型")
    private String type;

    /**
     * 商户号
     */
    @ApiModelProperty("商户号")
    private String mchntcd;

    /**
     * 富友用户id
     */
    @Column(name = "fuyou_user_id")
    @ApiModelProperty("富友用户id")
    private String fuyouUserId;

    /**
     * 返回码
     */
    @Column(name = "response_code")
    @ApiModelProperty("返回码")
    private String responseCode;

    /**
     * 返回码
     */
    @Column(name = "response_msg")
    @ApiModelProperty("返回码")
    private String responseMsg;

    /**
     * 订单编码
     */
    @Column(name = "order_number")
    @ApiModelProperty("订单编码")
    private String orderNumber;

    /**
     * 流水
     */
    @Column(name = "mchnt_order_id")
    @ApiModelProperty("流水")
    private String mchntOrderId;

    /**
     * 订单id
     */
    @Column(name = "order_id")
    @ApiModelProperty("订单id")
    private String orderId;

    /**
     * 金额
     */
    @ApiModelProperty("金额")
    private Long amt;

    /**
     * 银行卡号
     */
    @Column(name = "bank_card")
    @ApiModelProperty("银行卡号")
    private String bankCard;

    /**
     * 协议号
     */
    @Column(name = "protocol_no")
    @ApiModelProperty("协议号")
    private String protocolNo;

    /**
     * 还款类型
     */
    @Column(name = "pay_type")
    @ApiModelProperty("还款类型")
    private String payType;

    /**
     * 付款状态（-1为失败，0为进行中，1为成功）
     */
    @Column(name = "pay_status")
    @ApiModelProperty("付款状态（-1为失败，0为进行中，1为成功）")
    private Byte payStatus;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    @ApiModelProperty("修改时间")
    private Date updateTime;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取版本号
     *
     * @return version - 版本号
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置版本号
     *
     * @param version 版本号
     */
    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    /**
     * 获取类型
     *
     * @return type - 类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型
     *
     * @param type 类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取商户号
     *
     * @return mchntcd - 商户号
     */
    public String getMchntcd() {
        return mchntcd;
    }

    /**
     * 设置商户号
     *
     * @param mchntcd 商户号
     */
    public void setMchntcd(String mchntcd) {
        this.mchntcd = mchntcd == null ? null : mchntcd.trim();
    }

    /**
     * 获取富友用户id
     *
     * @return fuyou_user_id - 富友用户id
     */
    public String getFuyouUserId() {
        return fuyouUserId;
    }

    /**
     * 设置富友用户id
     *
     * @param fuyouUserId 富友用户id
     */
    public void setFuyouUserId(String fuyouUserId) {
        this.fuyouUserId = fuyouUserId == null ? null : fuyouUserId.trim();
    }

    /**
     * 获取返回码
     *
     * @return response_code - 返回码
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * 设置返回码
     *
     * @param responseCode 返回码
     */
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode == null ? null : responseCode.trim();
    }

    /**
     * 获取返回码
     *
     * @return response_msg - 返回码
     */
    public String getResponseMsg() {
        return responseMsg;
    }

    /**
     * 设置返回码
     *
     * @param responseMsg 返回码
     */
    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg == null ? null : responseMsg.trim();
    }

    /**
     * 获取订单编码
     *
     * @return order_number - 订单编码
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * 设置订单编码
     *
     * @param orderNumber 订单编码
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    /**
     * 获取流水
     *
     * @return mchnt_order_id - 流水
     */
    public String getMchntOrderId() {
        return mchntOrderId;
    }

    /**
     * 设置流水
     *
     * @param mchntOrderId 流水
     */
    public void setMchntOrderId(String mchntOrderId) {
        this.mchntOrderId = mchntOrderId == null ? null : mchntOrderId.trim();
    }

    /**
     * 获取订单id
     *
     * @return order_id - 订单id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置订单id
     *
     * @param orderId 订单id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 获取金额
     *
     * @return amt - 金额
     */
    public Long getAmt() {
        return amt;
    }

    /**
     * 设置金额
     *
     * @param amt 金额
     */
    public void setAmt(Long amt) {
        this.amt = amt;
    }

    /**
     * 获取银行卡号
     *
     * @return bank_card - 银行卡号
     */
    public String getBankCard() {
        return bankCard;
    }

    /**
     * 设置银行卡号
     *
     * @param bankCard 银行卡号
     */
    public void setBankCard(String bankCard) {
        this.bankCard = bankCard == null ? null : bankCard.trim();
    }

    /**
     * 获取协议号
     *
     * @return protocol_no - 协议号
     */
    public String getProtocolNo() {
        return protocolNo;
    }

    /**
     * 设置协议号
     *
     * @param protocolNo 协议号
     */
    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo == null ? null : protocolNo.trim();
    }

    /**
     * 获取还款类型
     *
     * @return pay_type - 还款类型
     */
    public String getPayType() {
        return payType;
    }

    /**
     * 设置还款类型
     *
     * @param payType 还款类型
     */
    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    /**
     * 获取付款状态（-1为失败，0为进行中，1为成功）
     *
     * @return pay_status - 付款状态（-1为失败，0为进行中，1为成功）
     */
    public Byte getPayStatus() {
        return payStatus;
    }

    /**
     * 设置付款状态（-1为失败，0为进行中，1为成功）
     *
     * @param payStatus 付款状态（-1为失败，0为进行中，1为成功）
     */
    public void setPayStatus(Byte payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}