package com.ald.news.domain.user;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author lianweiyue
 * @DATE 2018/1/15
 */
public class UserCommentVo {

    /**
     * 评论ID
     */
    @ApiModelProperty("评论ID")
    private Long id;

    /**
     * 第一级用户昵称
     */
    @ApiModelProperty("第一级用户昵称")
    private String firstNickname;

    /**
     * 第二级用户昵称
     */
    @ApiModelProperty("第二级用户昵称")
    private String secondNickname;

    /**
     * 第三级用户昵称
     */
    @ApiModelProperty("第三级用户昵称")
    private String thirdNickname;

    /**
     * 第一级用户ID
     */
    @ApiModelProperty("第一级用户ID")
    private Long firstUserId;

    /**
     * 第二级用户ID
     */
    @ApiModelProperty("第二级用户ID")
    private Long secondUserId;

    /**
     * 第三级用户ID
     */
    @ApiModelProperty("第三级用户ID")
    private Long thirdUserId;


//    /**
//     * 原评论ID
//     */
//    @Column(name = "to_comment_id")
//    @ApiModelProperty("原评论ID")
//    private Long toCommentId;

//    /**
//     * 第一级评论内容
//     */
//    @ApiModelProperty("第一级评论内容")
//    private String firstContent;

    /**
     * 第二级评论内容
     */
    @ApiModelProperty("第二级评论内容")
    private String secondContent;

    /**
     * 第三级用户评论内容
     */
    @ApiModelProperty("第三级用户评论内容")

    private String thirdContent;

    /**
     * 新闻ID
     */
    @Column(name = "news_id")
    @ApiModelProperty("新闻ID")
    private Long newsId;

    /**
     * 新闻ID
     */
    @Column(name = "title")
    @ApiModelProperty("新闻标题")
    private String title;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    @ApiModelProperty("创建时间")
    private Date gmtCreate;

    /**
     * 缩略图
     */
    @Column(name = "thumbnail_array")
    @ApiModelProperty("缩略图")
    private String thumbnailArray;

    /**
     * 获取缩略图
     *
     * @return thumbnail_array - 缩略图
     */
    public String getThumbnailArray() {
        return thumbnailArray;
    }

    /**
     * 设置缩略图
     *
     * @param thumbnailArray 缩略图
     */
    public void setThumbnailArray(String thumbnailArray) {
        this.thumbnailArray = thumbnailArray == null ? null : thumbnailArray.trim();
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
     * 获取新闻标题
     *
     * @return title  新闻标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置新闻标题
     *
     * @param title 新闻标题
     */
    public void setTitle(String title) {
        this.title = title;
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

//    /**
//     * 获取第一级评论内容
//     *
//     * @return firstContent - 第一级评论内容
//     */
//    public String getFirstContent() {
//        return firstContent;
//    }
//
//    /**
//     * 设置第一级用户评论内容
//     *
//     * @param firstContent 第一级用户评论内容
//     */
//    public void setFirstContent(String firstContent) {
//        this.firstContent = firstContent;
//    }

    /**
     * 获取第二级评论内容
     *
     * @return secondContent - 第二级评论内容
     */
    public String getSecondContent() {
        return secondContent;
    }

    /**
     * 设置第二级评论内容
     *
     * @param secondContent 第二级评论内容
     */
    public void setSecondContent(String secondContent) {
        this.secondContent = secondContent == null ? null : secondContent.trim();
    }

    /**
     * 获取第三级用户评论内容
     *
     * @return thirdContent - 第二级用户评论内容
     */
    public String getThirdContent() {
        return thirdContent;
    }

    /**
     * 设置第三级用户评论内容
     *
     * @param thirdContent 第二级用户评论内容
     */
    public void setThirdContent(String thirdContent) {
        this.thirdContent = thirdContent;
    }

//    /**
//     * 获取原评论ID
//     *
//     * @return to_comment_id - 原评论ID
//     */
//    public Long getToCommentId() {
//        return toCommentId;
//    }
//
//    /**
//     * 设置原评论ID
//     *
//     * @param toCommentId 原评论ID
//     */
//    public void setToCommentId(Long toCommentId) {
//        this.toCommentId = toCommentId;
//    }



    /**
     * 获取第二级用户ID
     *
     * @return secondUserId - 第二级用户ID
     */
    public Long getSecondUserId() {
        return secondUserId;
    }

    /**
     * 设置第二级用户ID
     *
     * @param secondUserId 第二级用户ID
     */
    public void setSecondUserId(Long secondUserId) {
        this.secondUserId = secondUserId;
    }



    /**
     * 获取用户 ID
     *
     * @return firstUserId - 第一级用户 ID
     */
    public Long getFirstUserId() {
        return firstUserId;
    }

    /**
     * 设置用户 ID
     *
     * @param firstUserId 第一级用户 ID
     */
    public void setFirstUserId(Long firstUserId) {
        this.firstUserId = firstUserId;
    }

    /**
     * 获取第一级用户昵称
     *
     * @return firstNickname - 第一级用户昵称
     */
    public String getFirstNickname() {
        return firstNickname;
    }

    /**
     * 设置第一级用户昵称
     *
     * @param firstNickname 第一级用户昵称
     */
    public void setFirstNickname(String firstNickname) {
        this.firstNickname = firstNickname == null ? null : firstNickname.trim();
    }

    /**
     * 获取评论ID
     *
     * @return id - 评论ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置评论ID
     *
     * @param id 评论ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取第二级用户昵称
     *
     * @return secondNickname - 第二级用户昵称
     */
    public String getSecondNickname() {
        return secondNickname;
    }
    /**
     * 设置第二级用户昵称
     *
     * @param secondNickname 第二级用户昵称
     */
    public void setSecondNickname(String secondNickname) {
        this.secondNickname = secondNickname;
    }


    /**
     * 获取第三级用户ID
     *
     * @return thirdUserId - 第三级用户ID
     */
    public Long getThirdUserId() {
        return thirdUserId;
    }

    /**
     * 设置第三级用户ID
     *
     * @param thirdUserId 第三级用户ID
     */
    public void setThirdUserId(Long thirdUserId) {
        this.thirdUserId = thirdUserId;
    }

    /**
     * 获取第三级用户昵称
     *
     * @return thirdNickname - 第三级用户昵称
     */
    public String getThirdNickname() {
        return thirdNickname;
    }

    /**
     * 设置第三级用户昵称
     *
     * @param thirdNickname 第三级用户昵称
     */
    public void setThirdNickname(String thirdNickname) {
        this.thirdNickname = thirdNickname;
    }

}
