package com.luoc.learn.handler;

import com.luoc.learn.exception.LearnException;
import com.luoc.learn.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 *
 * @author luoc
 * @version V1.0.0
 * @date 2018/1/27 17:59
 */
@ControllerAdvice
public class ExceptionHandle {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult handler(Exception e) {
        if (e instanceof LearnException) {
            LearnException learnException = (LearnException) e;
            return JsonResult.buildErrorJsonResult(learnException.getCode(), learnException.getMessage());
        } else {
            LOGGER.error("【系统异常】{}", e);
            return JsonResult.buildErrorJsonResult(-1, "未知错误");
        }
    }
}
