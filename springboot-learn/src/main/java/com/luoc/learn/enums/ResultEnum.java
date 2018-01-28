package com.luoc.learn.enums;

/**
 * @author luoc
 * @version V1.0.0
 * @date 2018/1/27 17:53
 */
public enum ResultEnum {
    UNKONW_ERROE(-1, "未知错误"),
    SUCCESS(200, "成功"),
    PRIMARY_SCHOOL(301, "我猜你可能还在上小学"),
    MIDDLE_SCHOOL(101, "你可能在上初中"),;


    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
