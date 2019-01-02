package com.ald.news.domain.user;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "news_version")
public class VersionDo {
    /**
     * 主键
     */
    @Id
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
     * 版本号
     */
    @Column(name = "version_code")
    @ApiModelProperty("版本号")
    private Integer versionCode;

    /**
     * 版本名字
     */
    @Column(name = "version_name")
    @ApiModelProperty("版本名字")
    private String versionName;

    /**
     * 发布时间
     */
    @Column(name = "publish_date")
    @ApiModelProperty("发布时间")
    private Date publishDate;

    /**
     * 1=IOS 2=安卓
     */
    @Column(name = "type")
    @ApiModelProperty("1=IOS 2=安卓")
    private String type;

    /**
     * 更新内容
     */
    @Column(name = "content")
    @ApiModelProperty("更新内容")
    private String content;

    /**
     * 新版本包路径
     */
    @Column(name = "url")
    @ApiModelProperty("新版本包路径")
    private String url;

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

    /**获取版本号
     * @return version_code
     */
    public Integer getVersionCode() {
        return versionCode;
    }

    /**设置版本号
     * @param versionCode
     */
    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    /**获取版本名字
     * @return version_name
     */
    public String getVersionName() {
        return versionName;
    }

    /**设置版本名字
     * @param versionName
     */
    public void setVersionName(String versionName) {
        this.versionName = versionName == null ? null : versionName.trim();
    }

    /**获取发布时间
     * @return publish_date
     */
    public Date getPublishDate() {
        return publishDate;
    }

    /**设置发布时间
     * @param publishDate
     */
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    /**1=IOS 2=安卓
     * @return type
     */
    public String getType() {
        return type;
    }

    /**1=IOS 2=安卓
     * @param type
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**获取更新内容
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**设置更新内容
     * @param content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**获取新版本包路径
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**设置新版本包路径
     * @param url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}