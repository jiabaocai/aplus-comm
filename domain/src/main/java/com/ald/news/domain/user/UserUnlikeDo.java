package com.ald.news.domain.user;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;

@Table(name = "news_user_unlike")
public class UserUnlikeDo {
    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private Long id;

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
     * 新闻ID
     */
    @Column(name = "news_id")
    @ApiModelProperty("新闻ID")
    private Long newsId;

    /**
     * 举报人ID
     */
    @Column(name = "user_id")
    @ApiModelProperty("举报人ID")
    private Long userId;

    /**
     * 不喜欢原因 1:内容质量差
     */
    @ApiModelProperty("不喜欢原因 1:内容质量差")
    private Boolean why;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
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
     * 获取新闻ID
     *
     * @return news_id - 新闻ID
     */
    public Long getNewsId() {
        return newsId;
    }

    /**
     * 设置新闻ID
     *
     * @param newsId 新闻ID
     */
    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    /**
     * 获取举报人ID
     *
     * @return user_id - 举报人ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置举报人ID
     *
     * @param userId 举报人ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取不喜欢原因 1:内容质量差
     *
     * @return why - 不喜欢原因 1:内容质量差
     */
    public Boolean getWhy() {
        return why;
    }

    /**
     * 设置不喜欢原因 1:内容质量差
     *
     * @param why 不喜欢原因 1:内容质量差
     */
    public void setWhy(Boolean why) {
        this.why = why;
    }
}