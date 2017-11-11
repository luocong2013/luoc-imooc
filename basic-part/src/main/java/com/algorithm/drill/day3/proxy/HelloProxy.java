package com.algorithm.drill.day3.proxy;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 实现接口的代理类（切面(Aspect)）
 *
 * @author Luo
 */
@SuppressWarnings("all")
public class HelloProxy implements Hello {
    private Hello helloObject;
    private Logger logger = Logger.getLogger(this.getClass().getName());

    public HelloProxy(Hello helloObject) {
        this.helloObject = helloObject;
    }

    public void log(String msg) {
        logger.log(Level.INFO, msg);
    }

    @Override
    public void hello(String name) {
        log("hello()方法开始执行");
        log("hello," + name);
        log("hello()方法执行完毕");
    }

}
