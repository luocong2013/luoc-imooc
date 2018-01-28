package com.luoc.learn.exception;

import com.luoc.learn.enums.ResultEnum;

/**
 * @author luoc
 * @version V1.0.0
 * @date 2018/1/27 17:52
 */
public class LearnException extends RuntimeException {
    private Integer code;

    public LearnException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
