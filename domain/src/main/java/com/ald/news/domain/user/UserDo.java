package com.ald.news.domain.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Table(name = "news_user")
public class UserDo {
    @Id
    @ApiModelProperty("")
    private Long id;

    /**
     * 第三方登陆用户 ID
     */
    @Column(name = "social_uid")
    @ApiModelProperty("第三方登陆用户 ID")
    private String socialUid;

    /**
     * 第三方登陆用户的令牌
     */
    @Column(name = "social_token")
    @ApiModelProperty("第三方登陆用户的令牌")
    private String socialToken;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String name;

    /**
     * 用户昵称
     */
    @ApiModelProperty("用户昵称")
    private String nickname;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String mobile;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

    /**
     * 客户端唯一标识号
     */
    @ApiModelProperty("客户端唯一标识号")
    private String uuid;

    /**
     * 推送的令牌
     */
    @Column(name = "push_token")
    @ApiModelProperty("推送的令牌")
    private String pushToken;

    /**
     * 性别(0->男, 1->女)
     */
    @ApiModelProperty("性别(0->男, 1->女)")
    private Byte sex;

    /**
     * 用户注册来源(0->iPhone, 1->iPad, 2->Android, 3->微信, 4->H5, 5->网站)
     */
    @ApiModelProperty("用户注册来源(0->iPhone, 1->iPad, 2->Android, 3->微信, 4->H5, 5->网站)")
    private Byte source;

    /**
     * 第三方登录来源(0->手机, 1->微信, 2->QQ)
     */
    @Column(name = "social_source")
    @ApiModelProperty("第三方登录来源(0->手机, 1->微信, 2->QQ)")
    private Long socialSource;

    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String avatar;

    /**
     * 经度
     */
    @ApiModelProperty("经度")
    private Float lng;

    /**
     * 纬度
     */
    @ApiModelProperty("纬度")
    private Float lat;

    /**
     * 省
     */
    @ApiModelProperty("省")
    private String province;

    /**
     * 城市
     */
    @ApiModelProperty("城市")
    private String city;

    /**
     * 区
     */
    @ApiModelProperty("区")
    private String area;

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
     * 获取第三方登陆用户 ID
     *
     * @return social_uid - 第三方登陆用户 ID
     */
    public String getSocialUid() {
        return socialUid;
    }

    /**
     * 设置第三方登陆用户 ID
     *
     * @param socialUid 第三方登陆用户 ID
     */
    public void setSocialUid(String socialUid) {
        this.socialUid = socialUid == null ? null : socialUid.trim();
    }

    /**
     * 获取第三方登陆用户的令牌
     *
     * @return social_token - 第三方登陆用户的令牌
     */
    public String getSocialToken() {
        return socialToken;
    }

    /**
     * 设置第三方登陆用户的令牌
     *
     * @param socialToken 第三方登陆用户的令牌
     */
    public void setSocialToken(String socialToken) {
        this.socialToken = socialToken == null ? null : socialToken.trim();
    }

    /**
     * 获取用户名
     *
     * @return name - 用户名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户名
     *
     * @param name 用户名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取用户昵称
     *
     * @return nickname - 用户昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置用户昵称
     *
     * @param nickname 用户昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取客户端唯一标识号
     *
     * @return uuid - 客户端唯一标识号
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置客户端唯一标识号
     *
     * @param uuid 客户端唯一标识号
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * 获取推送的令牌
     *
     * @return push_token - 推送的令牌
     */
    public String getPushToken() {
        return pushToken;
    }

    /**
     * 设置推送的令牌
     *
     * @param pushToken 推送的令牌
     */
    public void setPushToken(String pushToken) {
        this.pushToken = pushToken == null ? null : pushToken.trim();
    }

    /**
     * 获取性别(0->男, 1->女)
     *
     * @return sex - 性别(0->男, 1->女)
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 设置性别(0->男, 1->女)
     *
     * @param sex 性别(0->男, 1->女)
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * 获取用户注册来源(0->iPhone, 1->iPad, 2->Android, 3->微信, 4->H5, 5->网站)
     *
     * @return source - 用户注册来源(0->iPhone, 1->iPad, 2->Android, 3->微信, 4->H5, 5->网站)
     */
    public Byte getSource() {
        return source;
    }

    /**
     * 设置用户注册来源(0->iPhone, 1->iPad, 2->Android, 3->微信, 4->H5, 5->网站)
     *
     * @param source 用户注册来源(0->iPhone, 1->iPad, 2->Android, 3->微信, 4->H5, 5->网站)
     */
    public void setSource(Byte source) {
        this.source = source;
    }

    /**
     * 获取第三方登录来源(0->手机, 1->微信, 2->QQ)
     *
     * @return social_source - 第三方登录来源(0->手机, 1->微信, 2->QQ)
     */
    public Long getSocialSource() {
        return socialSource;
    }

    /**
     * 设置第三方登录来源(0->手机, 1->微信, 2->QQ)
     *
     * @param socialSource 第三方登录来源(0->手机, 1->微信, 2->QQ)
     */
    public void setSocialSource(Long socialSource) {
        this.socialSource = socialSource;
    }

    /**
     * 获取头像
     *
     * @return avatar - 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像
     *
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    /**
     * 获取经度
     *
     * @return lng - 经度
     */
    public Float getLng() {
        return lng;
    }

    /**
     * 设置经度
     *
     * @param lng 经度
     */
    public void setLng(Float lng) {
        this.lng = lng;
    }

    /**
     * 获取纬度
     *
     * @return lat - 纬度
     */
    public Float getLat() {
        return lat;
    }

    /**
     * 设置纬度
     *
     * @param lat 纬度
     */
    public void setLat(Float lat) {
        this.lat = lat;
    }

    /**
     * 获取省
     *
     * @return province - 省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省
     *
     * @param province 省
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 获取城市
     *
     * @return city - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 获取区
     *
     * @return area - 区
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置区
     *
     * @param area 区
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
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