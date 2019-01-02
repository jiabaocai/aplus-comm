package com.ald.news.user.service.impl;

import com.ald.news.core.base.BaseResponse;
import com.ald.news.core.base.BaseService;
import com.ald.news.domain.user.UserDo;
import com.ald.news.user.mapper.UserMapper;
import com.ald.news.user.service.UserService;
import com.ald.news.user.util.FileUploadUtil;
import com.ald.news.user.util.MobileRegexUtil;
import com.ald.news.user.util.RedisUtil;
import com.ald.news.user.util.SendSmsUtil;
import com.ald.news.utils.Constants;
import com.ald.news.utils.java.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.JedisCluster;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * @author xuxm
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ServletContext servletContext;

    @Override
    public BaseResponse getVerificationCode(String mobile) {
        // 校验格式
        if (MobileRegexUtil.isMobileNumber(mobile)) {
            try {
                //检查手机短信发送频率(1.间隔多久发送一次 2.一天累计发送几次)
                RedisUtil.checkSendFrequency(mobile);
                //发送短信-产生验证码
                String verificationCode = SendSmsUtil.createVerificationCode(Constants.SMS.SMS_CODE_LENGTH);
                System.out.println("=============================================[调试日志]" + mobile + "短信验证码为" + verificationCode);
                //发送短信-调运营商接口发送
                if (SendSmsUtil.callOperatorSendSMS(mobile, verificationCode)) {
                    //验证码存入redis
                    RedisUtil.msgCodeToRedis(mobile, verificationCode);
                    return BaseResponse.newInstance(Constants.ResponseCode.SUCCEED_CODE_VALUE, Constants.SMS.SEND_SMS_SUCCESS);
                }
                return BaseResponse.newInstance(Constants.ResponseCode.FAIL_CODE_VALUE, Constants.SMS.SEND_SMS_FAIL);
            } catch (Exception e) {
                return BaseResponse.newInstance(Constants.ResponseCode.FAIL_CODE_VALUE, e.getMessage());
            }
        }
        return BaseResponse.newInstance(Constants.ResponseCode.FAIL_CODE_VALUE, Constants.SMS.MOBILE_FORMAT_INCORRECT);
    }

    /**
     * 用户注册(登录后验证码已校验)
     *
     * @param mobile 手机号码
     */
    private boolean register(String mobile) {
        // 检查手机号码是否已注册
        if (RedisUtil.isKeyExists(Constants.Redis.KEY_MOBILE, mobile)) {
            return false;
        }
        // 构建用户对象
        UserDo user = new UserDo();
        user.setMobile(mobile);
        try {
            // 产生指定位数UUID
            String uuid = autoCreateUUID(Constants.Redis.KEY_UUID, Constants.User.USER_UUID_LENGTH);
            // 产生指定位数随机昵称
            String nickname = autoCreateNickname(Constants.Redis.KEY_NICKNAME,
                    Constants.User.USER_NICKNAME_PREFIX,
                    Constants.User.USER_NICKNAME_LENGTH);
            user.setUuid(uuid);
            user.setNickname(nickname);
            // 用户数据入MySQL库
            if (userMapper.insertSelective(user) > 0) {
                // 用户数据入Redis库
                //  1.手机号码去重
                //  2.UUID去重
                //  3.昵称去重
                System.out.println("=============================================[调试日志]======>数据入MySQL库成功");
                RedisUtil.insertRedis(Constants.Redis.KEY_PREFIX + Constants.Redis.KEY_MOBILE, mobile);
                RedisUtil.insertRedis(Constants.Redis.KEY_PREFIX + Constants.Redis.KEY_UUID, uuid);
                RedisUtil.insertRedis(Constants.Redis.KEY_PREFIX + Constants.Redis.KEY_NICKNAME, nickname);
                System.out.println("=============================================[调试日志]======>数据入Redis库成功");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 生成UUID
     * 1.指定位数-纯数字
     * 2.不重复,redis校验
     *
     * @param keyType 字段类型
     * @param length  随机码长度
     * @return 随机码
     */
    private String autoCreateUUID(String keyType, int length) {
        return autoCreateNickname(keyType, "", length);
    }

    /**
     * 生成昵称(针对本地用户-自动分配昵称)
     * 1.统一产品前缀+六位随机数字码
     * 2.昵称不重复,redis校验
     *
     * @param keyType 字段类型
     * @param length  随机码长度
     * @return 返回生成昵称
     */
    private static String autoCreateNickname(String keyType, String prefix, int length) {
        System.out.println("=============================================[调试日志]检查keyType = [" + keyType + "], prefix = [" + prefix + "], length = [" + length + "]");
        //产生随机昵称后缀
        String key = prefix + StringUtil.createRandomCode(length);
        //检查昵称是否存在(redis)
        while (RedisUtil.isKeyExists(keyType, key)) {
            System.out.println("=============================================[调试日志]检查while-1" + keyType + "====>" + key + "存在");
            key = prefix + StringUtil.createRandomCode(length);
            System.out.println("=============================================[调试日志]检查while-2" + keyType + "====>" + key + "存在");
        }
        System.out.println("=============================================[调试日志]检查end" + keyType + "====>" + key + "存在");
        //加上默认新闻产品前缀
        return key;
    }

    @Override
    public BaseResponse localLogin(String mobile, String verificationCode) {
        // 校验手机和验证码非空和长度
        if (mobile.isEmpty()
                || verificationCode.isEmpty()
                || mobile.length() != 11
                || verificationCode.length() != Constants.SMS.SMS_CODE_LENGTH) {
            return BaseResponse.newInstance(Constants.ResponseCode.FAIL_CODE_VALUE, Constants.SMS.MOBILE_OR_CODE_INCORRECT);
        }
        // 校验手机格式不匹配
        if (!MobileRegexUtil.isMobileNumber(mobile)) {
            return BaseResponse.newInstance(Constants.ResponseCode.FAIL_CODE_VALUE, Constants.SMS.MOBILE_FORMAT_INCORRECT);
        }
        // redis获取手机对应验证码
        JedisCluster cluster = RedisUtil.getCluster();
        String msgCode = cluster.get(Constants.Redis.KEY_PREFIX + Constants.Redis.KEY_SMS + mobile);
        // 验证码过期(redis验证码过期)
        if (msgCode == null) {
            return BaseResponse.newInstance(Constants.ResponseCode.FAIL_CODE_VALUE, Constants.User.VERIFICATIONCODE_EXPIRE);
        }
        // 验证码匹配
        if (msgCode.equals(verificationCode)) {
            // 判断手机号码是否注册
            if (!RedisUtil.isKeyExists(Constants.Redis.KEY_MOBILE + Constants.Redis.KEY_MOBILE, mobile)) {
                // 未注册,去注册
                if (register(mobile)) {
                    // 同步更新到redis
                    return BaseResponse.newInstance(Constants.ResponseCode.SUCCEED_CODE_VALUE, Constants.User.USER_LOGIN_SUCCESS);
                }
                return BaseResponse.newInstance(Constants.ResponseCode.FAIL_CODE_VALUE, Constants.User.USER_LOGIN_FAIL);
            }
            // 已注册
            return BaseResponse.newInstance(Constants.ResponseCode.SUCCEED_CODE_VALUE, Constants.User.USER_LOGIN_SUCCESS);
        }
        // 验证码不匹配
        return BaseResponse.newInstance(Constants.ResponseCode.FAIL_CODE_VALUE, Constants.User.VERIFICATIONCODE_INCORRECT);

    }

    @Override
    public BaseResponse thirdPartyLogin() {
        System.out.println("===================================");
        System.out.println("UserServiceImpl.thirdPartyLogin");
        return new BaseResponse();
    }

    @Override
    public BaseResponse updateUserInfo(Long userId, MultipartFile pic, String nickname) {
        //用户ID为空保存失败
        //如果用户ID和图片不为空,上传图片
        if (userId != null && pic != null) {
            String realPath = servletContext.getRealPath("/upload");
            String imagePath = FileUploadUtil.upload(pic, realPath);
            UserDo user = new UserDo();
            user.setAvatar(imagePath);
            userMapper.updateByPrimaryKeySelective(user);
        } else {
            throw new RuntimeException("上传头像为空!");
        }
        return null;
    }

    @Override
    public BaseResponse findById(Long id) {
        UserDo user = userMapper.selectByPrimaryKey(id);
        BaseResponse response = new BaseResponse();
        response.setData(user);
        response.setCode(Constants.ResponseCode.SUCCEED_CODE_VALUE);
        return response;
    }

    @Override
    public List<UserDo> getUserByPrimarykey(List<Long> replyUserIdList) {
        return userMapper.getUserByPrimarykey(replyUserIdList);
    }
}
