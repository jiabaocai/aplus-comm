package com.ald.news.utils.encrypt;

import com.ald.news.utils.Constants;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class DigestUtil {

    private static final Logger logger = LoggerFactory.getLogger(DigestUtil.class);


    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     *
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    public static String convertMapToMd5Str(final Map<String, String> params) {
        return convertMapToMd5Str(params, null);
    }

    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     *
     * @param params    需要排序并参与字符拼接的参数组
     * @param ignoreKey 不参与拼接的字符串
     * @return 拼接后字符串
     */
    public static String convertMapToMd5Str(final Map<String, String> params, String[] ignoreKey) {

        if (ignoreKey == null || ignoreKey.length == 0) {
            ignoreKey = new String[]{null};
        } else {
            String[] paramsWithNull = new String[ignoreKey.length + 1];
            System.arraycopy(ignoreKey, 0, paramsWithNull, 0, ignoreKey.length);
            ignoreKey = paramsWithNull;
        }

        List<String> keys = new ArrayList<String>(params.keySet());

        //不改变params的前提下去除所有的null键和需要排除的键
        keys.removeAll(Arrays.asList(ignoreKey));

        Collections.sort(keys);

        StringBuffer prestr = new StringBuffer();

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            prestr.append(key);
            prestr.append("=");
            prestr.append(value);
            if (i < keys.size() - 1) // 拼接时，不包括最后一个&字符
                prestr.append("&");
        }

        return prestr.toString();
    }

    /**
     * 获取16位MD5码
     *
     * @param md5Str
     * @return
     */
    public static String MD5_16(String md5Str) {
        String md5 = MD5(md5Str);
        return StringUtils.substring(md5, 8, 24);
    }

    /**
     * 32位Md5码
     *
     * @param md5Str
     * @return
     */
    public static String MD5(String md5Str) {
        if (StringUtils.isBlank(md5Str)) {
            return null;
        }
        return DigestUtils.md5Hex(md5Str);
    }

    public static String getSha1Code(MultipartFile fileObj) throws IOException {
        if (null == fileObj) {
            return StringUtils.EMPTY;
        }
        InputStream ins = null;
        try {
            ins = fileObj.getInputStream();
            return DigestUtils.sha1Hex(ins);
        } catch (Exception e) {
            return StringUtils.EMPTY;
        } finally {
            if (null != ins) {
                ins.close();
            }
        }
    }

    public static String getMd5(String pathname) throws IOException {
        if (StringUtils.isBlank(pathname)) {
            return StringUtils.EMPTY;
        }
        InputStream ins = null;
        try {
            ins = new FileInputStream(pathname);
            return DigestUtils.md5Hex(ins);
        } catch (Exception e) {
            return StringUtils.EMPTY;
        } finally {
            if (null != ins) {
                ins.close();
            }
        }
    }

    public static String getSha1Code(String pathname) throws IOException {
        if (StringUtils.isBlank(pathname)) {
            return StringUtils.EMPTY;
        }
        InputStream ins = null;
        try {
            ins = new FileInputStream(pathname);
            return getSha1Code(ins);
        } catch (Exception e) {
            return StringUtils.EMPTY;
        } finally {
            if (null != ins) {
                ins.close();
            }
        }
    }

    public static String getMd5(File file) throws IOException {
        if (null == file) {
            return StringUtils.EMPTY;
        }
        InputStream ins = null;
        try {
            ins = new FileInputStream(file);
            return getMd5(ins);
        } catch (Exception e) {
            return StringUtils.EMPTY;
        } finally {
            if (null != ins) {
                ins.close();
            }
        }
    }

    public static String getSha1Code(File file) throws IOException {
        if (null == file) {
            return StringUtils.EMPTY;
        }
        InputStream ins = null;
        try {
            ins = new FileInputStream(file);
            return getSha1Code(ins);
        } catch (Exception e) {
            return StringUtils.EMPTY;
        } finally {
            if (null != ins) {
                ins.close();
            }
        }
    }

    public static String getSha1Code(byte[] byteArray) throws IOException {
        if (null == byteArray || byteArray.length < 1) {
            return StringUtils.EMPTY;
        }
        return DigestUtils.sha1Hex(byteArray);
    }

    /**
     * get Sha1 Code with inputStream
     *
     * @param iStream
     * @return
     * @throws IOException
     */
    public static String getSha1Code(InputStream iStream) throws IOException {
        if (null == iStream) {
            return StringUtils.EMPTY;
        }
        return DigestUtils.sha1Hex(iStream);
    }

    /**
     * Generate Sha1 Code with inputStream
     *
     * @param iStream
     * @return
     * @throws IOException
     */
    public static String getMd5(InputStream iStream) throws IOException {
        if (null == iStream) {
            return StringUtils.EMPTY;
        }
        return DigestUtils.md5Hex(iStream);
    }

    /**
     * 根据流获取文件的sha1值
     *
     * @param in
     * @return
     * @throws OutOfMemoryError
     * @throws IOException
     */
    public static String getFileSha1(InputStream in) throws OutOfMemoryError, IOException {
        try {
            return byte2hex(digest(in, Constants.Encrypt.SHA_1));
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (null != in) {
                in.close();
            }
        }
    }

    /**
     * 对字符串进行给定算法散列(无盐值)
     *
     * @param bytes
     * @param algorithm
     * @return
     */
    public static byte[] digestString(byte[] bytes, String algorithm) {
        return digest(bytes, algorithm, null, 1);
    }

    /**
     * 对字符串进行给定算法散列(包含盐值)
     *
     * @param bytes
     * @param algorithm
     * @return
     */
    public static byte[] digestString(byte[] bytes, byte[] salt, String algorithm) {
        return digest(bytes, algorithm, salt, 1);
    }

    /**
     * 对字符串进行给定次数和指定算法的散列(包含盐值)
     *
     * @param bytes
     * @param algorithm
     * @return
     */
    public static byte[] digestString(byte[] bytes, byte[] salt, int counts, String algorithm) {
        return digest(bytes, algorithm, salt, counts);
    }

    /**
     * 生成随机salt的字节数组
     *
     * @param num
     * @return
     */
    public static byte[] generateSalt(int num) {
        Validate.isTrue(num > 0, "num argument must be a positive integer, larger than 0", num);

        byte[] bytes = new byte[num];
        SecureRandom random = new SecureRandom();
        random.nextBytes(bytes);
        return bytes;
    }

    /**
     * 对文件进行指定算法的散列散列
     *
     * @param bytes
     * @return
     * @throws IOException
     */
    public static byte[] digestFile(InputStream bytes, String algorithm) throws IOException {
        return digest(bytes, algorithm);
    }

    private static byte[] digest(byte[] bytes, String algorithm, byte[] salt, int counts) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            if (salt != null) {
                digest.update(salt);
            }

            byte[] result = digest.digest(bytes);

            for (int i = 1; i < counts; i++) {
                digest.reset();
                result = digest.digest(result);
            }
            return result;
        } catch (GeneralSecurityException e) {
            logger.error("general security exception occurs, detail exception is ", e);
            return null;
        }
    }

    private static byte[] digest(InputStream input, String algorithm) throws IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            byte[] buffer = new byte[Constants.Global.DEFAULT_BUFFER_LENGTH];
            int read = input.read(buffer, 0, Constants.Global.DEFAULT_BUFFER_LENGTH);

            while (read > -1) {
                messageDigest.update(buffer, 0, read);
                read = input.read(buffer, 0, Constants.Global.DEFAULT_BUFFER_LENGTH);
            }

            return messageDigest.digest();
        } catch (GeneralSecurityException e) {
            logger.error("general security exception occurs when digest inputstream ", e);
            return null;
        }
    }

    /**
     * byte[]字节组转为字符串
     *
     * @param b
     * @return
     */
    private static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
            if (n < b.length - 1) {
                hs = hs + ":";
            }
        }
        return hs.toUpperCase(Locale.ENGLISH);
    }

    /**
     * decode String to bytes[]
     *
     * @param src
     * @return
     */
    public static byte[] decodeHex(String src) {
        if (StringUtils.isBlank(src)) return null;
        try {
            return Hex.decodeHex(src.toCharArray());
        } catch (DecoderException e) {
            logger.error("decode hex src failed, src vlaue is " + src, e);
        }
        return null;
    }

    public static String encodeHex(byte[] data) {
        return Hex.encodeHexString(data);
    }

    public static void main(String[] args) {
//        byte[] saltBytes = DigestUtil.generateSalt(Constants.DEFAULT_BYTES_SIZE);
//        String salt = DigestUtil.encodeHex(saltBytes);
//        System.out.println(salt);
        Map<String, String> map = new HashMap<String, String>();
        map.put("A", "1");
        map.put("B", "2");
        map.put("C", "3");
        map.put("D", "4");
        map.put("E", "5");
        map.put("F", "6");
        map.put("SIGN", "7");
        map.put("SIGN_TYPE", "8");
        map.put(null, "null");
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("X", "9");
        map2.put("y", "10");
        map.put("G", "{" + convertMapToMd5Str(map2) + "}");
        String convertMapToMd5Str = convertMapToMd5Str(map, new String[]{"SIGN"});
        System.out.println(convertMapToMd5Str);
        System.out.println(map);

    }

//    public static void main(String[] args) {
//        byte[] salts = generateSalt(8);
//        String saltRaw = "d2eb9f693820ce5d";
//        byte[] saltsRawBytes = CodecUtil.decodeHex(saltRaw);
//        System.out.println(saltsRawBytes);
//        String passwordRaw = "hello1234";
//        byte[] hashPasswordRaw = digestString(passwordRaw.getBytes(), saltsRawBytes, 1024, ConstantPool.SHA1);
//        System.out.println(CodecUtil.encodeHex(hashPasswordRaw));
//
//        System.out.println(salts);
//        String salt = CodecUtil.encodeHex(salts);
//        System.out.println(salt);
//        byte[] salts2 = CodecUtil.decodeHex(salt);
//        System.out.println(salts2);
//        System.out.println(CodecUtil.encodeHex(salts2));
//        String password = "123456";
//        byte[] hashPassword = digestString(password.getBytes(), salts, 1024, ConstantPool.SHA1);
//        System.out.println(CodecUtil.encodeHex(hashPassword));
//        byte[] hashPassword2 = digestString(password.getBytes(), salts2, 1024, ConstantPool.SHA1);
//        System.out.println(CodecUtil.encodeHex(hashPassword2));
//    }

}
