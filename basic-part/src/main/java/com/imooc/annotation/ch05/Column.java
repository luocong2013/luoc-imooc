package com.imooc.annotation.ch05;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.annotation.ch05
 * @description: TODO
 * @date 2017/11/9 22:33
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

    String value();
    
}
