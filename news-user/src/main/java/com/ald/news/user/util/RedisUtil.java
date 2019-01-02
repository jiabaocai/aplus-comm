package com.ald.news.user.util;

import com.ald.news.utils.Constants;
import com.ald.news.utils.java.DateUtil;
import redis.clients.jedis.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Redis连接池工具类
 *
 * @author xuxm
 */
public final class RedisUtil {

    /**
     * 短信验证码入库(含发送频率检测和每天最多发送次数检测的衍生key)
     * 以手机号码为主,主要包含以下三类key：
     * 1.key 手机号码 验证码
     * 2.key 手机号码-busy 发送间隔时间
     * 3.key 手机号码-send-count 每天发送累计次数
     *
     * @param mobile           手机号码
     * @param verificationCode 验证码
     */
    public static void msgCodeToRedis(String mobile, String verificationCode) {
        JedisCluster cluster = getCluster();
        //控制发送频率和每天最多发送次数,以手机号码为准
        String key = Constants.Redis.KEY_PREFIX + Constants.Redis.KEY_SMS + mobile;
        String keyBusy = key + Constants.Redis.KEY_BUSY;
        String keySendCount = key + Constants.Redis.KEY_SEND_COUNT;
        //存储到Redis,设置过期时间
        cluster.set(key, verificationCode);
        cluster.expire(key, Constants.SMS.SMS_VERIFICATIONCODE_OVERTIME * 60);
        //设置短信发送频率控制
        cluster.set(keyBusy, Constants.Redis.KEY_BUSY);
        cluster.expire(keyBusy, Constants.Redis.SMS_TIMEOUT);
        //设置短信发送频率控制,存在对应的key,则在原有基础上加1
        String keySendCountValue = cluster.get(keySendCount);
        if (keySendCountValue == null) {
            cluster.set(keySendCount, "1");
        } else {
            cluster.incr(keySendCount);
        }
        cluster.expireAt(keySendCount, DateUtil.getEndOfDateTimestamp(new Date()));
    }

    /**
     * 检查手机号码发送频率，包含以下两个检测点：
     * 1.手机号码间隔多久发送一次
     * 2.每天手机号码最多发送几次
     */
    public static void checkSendFrequency(String mobile) {
        JedisCluster cluster = getCluster();
        //控制发送频率和每天最多发送次数,以手机号码为准
        String key = Constants.Redis.KEY_PREFIX + Constants.Redis.KEY_SMS + mobile;
        String keyBusy = key + Constants.Redis.KEY_BUSY;
        String keySendCount = key + Constants.Redis.KEY_SEND_COUNT;
        //检查手机号码每日发送次数
        String keySendCountValue = cluster.get(keySendCount);
        if (keySendCountValue != null && keySendCountValue.equals(Constants.Redis.SMS_DAY_COUNT)) {
            throw new RuntimeException("今天发送次数已达到" + Constants.Redis.SMS_DAY_COUNT + ",不能再发送了");
        }
        //检查手机号码发送频率时间间隔
        if (cluster.get(keyBusy) != null) {
            throw new RuntimeException("短信发送太频繁");
        }
    }

    /**
     * 检查某个类型的key是否存在redis中
     *
     * @param keyType  key的类型,关于key类型值 @see Constants.Redis
     * @param keyValue key的值
     * @return 存在返回true，否则返回false
     */
    public static boolean isKeyExists(String keyType, String keyValue) {
        JedisCluster cluster = getCluster();
        String key = Constants.Redis.KEY_PREFIX + keyType + keyValue;
        String keySendCountValue = cluster.get(key);
        return keySendCountValue != null;
    }

    /**
     * 集群模式
     */
    public static JedisCluster getCluster() {
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.106.135", 7000));
        nodes.add(new HostAndPort("192.168.106.136", 7002));
        nodes.add(new HostAndPort("192.168.106.137", 7004));
        return new JedisCluster(nodes);
    }

    /**
     * 数据入redis库
     *
     * @param keyType 数据类型
     * @param keyName 数据名称
     */
    public static void insertRedis(String keyType, String keyName) {
        JedisCluster cluster = getCluster();
        cluster.set(keyType + keyName, "");
    }
}