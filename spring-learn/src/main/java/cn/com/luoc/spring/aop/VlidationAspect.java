package cn.com.luoc.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 可以使用 @Order 注解指定切面的优先级, 值越小优先级越高
 *
 * @author luoc
 * @version V1.0.0
 * @date 2018/2/12 16:04
 */
@Order(1)
@Aspect
@Component
public class VlidationAspect {

    @Before("cn.com.luoc.spring.aop.LoggingAspect.declareJoinPointExpression()")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("-->validate:" + Arrays.asList(joinPoint.getArgs()));
    }
}
