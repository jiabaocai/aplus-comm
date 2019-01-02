package com.ald.news.user.util;

import com.ald.news.utils.Constants;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * 短信发送工具类
 *
 * @author xuxm
 */
public class SendSmsUtil {

    /**
     * 产生对应位数验证码(纯数字),至少4位
     *
     * @param codeLength 验证码长度
     * @return 验证码字符串
     */
    public static String createVerificationCode(int codeLength) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < (codeLength > 4 ? codeLength : 4); i++) {
            stringBuilder.append((int) (Math.random() * 10));
        }
        return stringBuilder.toString();
    }

    /**
     * 调第三方运营商发送短信服务接口,向用户发送短信
     *
     * @param mobile           手机号码
     * @param verificationCode 验证码
     * @return 发送成功返回true, 发送失败返回false
     */
    public static boolean callOperatorSendSMS(String mobile, String verificationCode) {
        //连接/读取超时,30秒
        System.setProperty("sun.net.client.defaultConnectTimeout", "30000");
        System.setProperty("sun.net.client.defaultReadTimeout", "30000");
        StringBuffer buffer = null;
        String smsUrl = "http://todo";                     //短信运营商发送短信接口地址
        String encode = "UTF-8";                    //短信内容编码
        String username = "";                       //用户名
        String password_md5 = "";                   //密码
        String apikey = "";                         //密钥
        String content = "[E都市新闻]短信验证码为"      //短信内容
                + verificationCode + ","
                + Constants.SMS.SMS_VERIFICATIONCODE_OVERTIME + "分钟内有效.";
        try {
            //短信内容编码
            String contentUrlEncode = URLEncoder.encode(content, encode);
            buffer = new StringBuffer();
            //url拼接
            buffer.append(smsUrl).
                    append("?username=").append(username).
                    append("&password_md5=").append(password_md5).
                    append("&mobile=").append(mobile).
                    append("&apikey=").append(apikey).
                    append("&content=").append(contentUrlEncode).
                    append("&encode=").append(encode);
            URL url = new URL(buffer.toString());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            //使用长链接方式
            connection.setRequestProperty("Connection", "Keep-Alive");
            //===================================================================
            //发送短信内容
            //BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            //获取返回值
            //String result = reader.readLine();
            //return result.contains("success");
            return true;                                    //TODO @xuxm调试-待接入短信新运营商
            //===================================================================
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
