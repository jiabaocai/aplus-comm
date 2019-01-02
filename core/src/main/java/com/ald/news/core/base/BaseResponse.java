package com.ald.news.core.base;

import com.ald.news.utils.Constants;

/**
 * @author cjb
 */
public class BaseResponse<T> {

    private int code;
    private String msg;
    private T data;
    private String token;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 成功的返回
     * @param data
     * @return
     */
    public static <T> BaseResponse<T> newSuccessInstance(T data) {
        BaseResponse response = new BaseResponse();
        response.setCode(Constants.ResponseCode.SUCCEED_CODE_VALUE);
        response.setMsg(Constants.Global.OPERATION_SUCCESS);
        response.setData(data);
        return response;
    }

    /**
     * 失败的返回
     * 标准失败的返回信息
     * @param code
     * @return
     */
    public static <T> BaseResponse<T> newFailInstance(int code) {
        BaseResponse response = new BaseResponse();
        response.setCode(code);
        response.setMsg(Constants.Global.OPERATION_SUCCESS);
        return response;
    }

    public static BaseResponse newInstance(int code, String msg) {
        BaseResponse response = new BaseResponse();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    public static <T> BaseResponse<T> newInstance(int code, String msg, T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
