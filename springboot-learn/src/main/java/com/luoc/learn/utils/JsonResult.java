package com.luoc.learn.utils;

import java.io.Serializable;

/**
 * http请求返回的最外层对象
 *
 * @author luoc
 * @version V1.0.0
 * @date 2018/1/27 16:43
 */
public class JsonResult implements Serializable {

    public final static int HTTP_SUCCESS_CODE = 200;
    public final static int HTTP_ERROR_CODE = 300;
    public final static String HTTP_SUCCESS_MSG = "请求处理成功";
    public final static String HTTP_ERROR_MSG = "请求处理失败";

    /**
     * 错误码
     */
    private int code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 具体内容
     */
    private Object data;

    public static JsonResult buildSuccessJsonResult() {
        return new JsonResult(HTTP_SUCCESS_CODE, HTTP_SUCCESS_MSG);
    }

    public static JsonResult buildSuccessJsonResult(Object data) {
        return new JsonResult(HTTP_SUCCESS_CODE, HTTP_SUCCESS_MSG, data);
    }

    public static JsonResult buildSuccessJsonResult(String msg, Object data) {
        return new JsonResult(HTTP_SUCCESS_CODE, msg, data);
    }


    public static JsonResult buildErrorJsonResult() {
        return new JsonResult(HTTP_ERROR_CODE, HTTP_ERROR_MSG);
    }

    public static JsonResult buildErrorJsonResult(int code) {
        return new JsonResult(code, HTTP_ERROR_MSG);
    }

    public static JsonResult buildErrorJsonResult(String msg) {
        return new JsonResult(HTTP_ERROR_CODE, msg);
    }

    public static JsonResult buildErrorJsonResult(int code, String msg) {
        return new JsonResult(code, msg);
    }

    public static JsonResult buildJsonResult(int code, String msg, Object data) {
        return new JsonResult(code, msg, data);
    }

    public JsonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
