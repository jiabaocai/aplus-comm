package com.ald.news.user.service;

import com.ald.news.core.base.BaseResponse;
import com.ald.news.domain.user.UserDo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author xuxm
 */
public interface UserService {
    /**
     * 获取验证码
     *
     * @param mobile 手机号码
     * @return
     */
    BaseResponse getVerificationCode(String mobile);

    /**
     * 登录(本地)
     *
     * @param mobile           手机号码
     * @param verificationCode 验证码
     * @return
     */
    BaseResponse localLogin(String mobile, String verificationCode);

    /**
     * 登录(三方)
     *
     * @return
     */
    BaseResponse thirdPartyLogin();

    /**
     * 修改用户信息
     *
     * @param userId   用户ID
     * @param pic      图片文件
     * @param nickname 昵称
     * @return
     */
    BaseResponse updateUserInfo(Long userId, MultipartFile pic, String nickname);

    /**
     * 获取用户详情
     *
     * @param id 用户ID
     * @return
     */
    BaseResponse findById(Long id);

    List<UserDo> getUserByPrimarykey(List<Long> replyUserIdList);
}
