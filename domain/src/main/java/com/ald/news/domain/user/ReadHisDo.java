package com.ald.news.domain.user;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "news_read_his")
public class ReadHisDo {
    @Id
    @ApiModelProperty("")
    private Long id;

    /**
     * 用户 ID
     */
    @Column(name = "user_id")
    @ApiModelProperty("用户 ID")
    private Long userId;

    /**
     * 新闻 ID
     */
    @Column(name = "news_id")
    @ApiModelProperty("新闻 ID")
    private String newsId;

    /**
     * 当前新闻阅读时间 单位秒
     */
    @Column(name = "read_time")
    @ApiModelProperty("当前新闻阅读时间 单位秒")
    private Long readTime;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private Byte status;

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
     * 获取新闻 ID
     *
     * @return news_id - 新闻 ID
     */
    public String getNewsId() {
        return newsId;
    }

    /**
     * 设置新闻 ID
     *
     * @param newsId 新闻 ID
     */
    public void setNewsId(String newsId) {
        this.newsId = newsId == null ? null : newsId.trim();
    }

    /**
     * 获取当前新闻阅读时间 单位秒
     *
     * @return read_time - 当前新闻阅读时间 单位秒
     */
    public Long getReadTime() {
        return readTime;
    }

    /**
     * 设置当前新闻阅读时间 单位秒
     *
     * @param readTime 当前新闻阅读时间 单位秒
     */
    public void setReadTime(Long readTime) {
        this.readTime = readTime;
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
}