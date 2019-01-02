package com.ald.news.domain.user;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "news_user_channel")
public class UserChannelDo {
    
    @ApiModelProperty("")
    private Long id;

    /**
     * 用户 ID
     */
    @Column(name = "user_id")
    @ApiModelProperty("用户 ID")
    private Long userId;

    /**
     * 关注频道，多个频道之间逗号隔开，顺序
     */
    @ApiModelProperty("关注频道，多个频道之间逗号隔开，顺序")
    private String channel;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    @ApiModelProperty("创建时间")
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @Column(name = "gmt_update")
    @ApiModelProperty("更新时间")
    private Date gmtUpdate;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private Byte status;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户 ID
     *
     * @return user_id - 用户 ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户 ID
     *
     * @param userId 用户 ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取关注频道，多个频道之间逗号隔开，顺序
     *
     * @return channel - 关注频道，多个频道之间逗号隔开，顺序
     */
    public String getChannel() {
        return channel;
    }

    /**
     * 设置关注频道，多个频道之间逗号隔开，顺序
     *
     * @param channel 关注频道，多个频道之间逗号隔开，顺序
     */
    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    /**
     * 获取创建时间
     *
     * @return gmt_create - 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置创建时间
     *
     * @param gmtCreate 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取更新时间
     *
     * @return gmt_update - 更新时间
     */
    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    /**
     * 设置更新时间
     *
     * @param gmtUpdate 更新时间
     */
    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Byte status) {
        this.status = status;
    }
}