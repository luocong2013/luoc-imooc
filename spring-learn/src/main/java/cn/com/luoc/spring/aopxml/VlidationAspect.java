package cn.com.luoc.spring.aopxml;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author luoc
 * @version V1.0.0
 * @date 2018/2/12 16:04
 */
@Component
public class VlidationAspect {

    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("-->validate:" + Arrays.asList(joinPoint.getArgs()));
    }
}
