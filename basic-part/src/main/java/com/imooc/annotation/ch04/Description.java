package com.imooc.annotation.ch04;

import java.lang.annotation.*;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.annotation.ch04
 * @description: 自定义注解类
 * @date 2017/11/9 22:19
 */
@Target({ElementType.METHOD, ElementType.TYPE}) //CONSTRUCTOR: 构造方法声明、FIELD: 字段声明、LOCAL_VARIABLE: 局部变量声明、METHOD: 方法声明、PACKAGE: 包声明、PARAMETER: 参数声明、TYPE: 类接口
@Retention(RetentionPolicy.RUNTIME) //生命周期：SOURCE: 只在源码显示，编译时会丢弃、CLASS: 编译时会记录到class中，运行时忽略、RUNTIME: 运行时存在，可以通过反射读取
@Inherited //允许子类继承
@Documented //生成javadoc时会包含注解
public @interface Description {
    String desc();

    String author();

    int age() default 20;
}
