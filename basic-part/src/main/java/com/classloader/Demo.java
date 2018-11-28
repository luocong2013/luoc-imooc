package com.classloader;

/**
 * @author luoc
 * @version V1.0.0
 * @description ClassLoader测试1
 * @date 2018/11/28 21:01
 */
public class Demo {
    public Demo() {
        System.out.println("A Demo: " + this.getClass().getClassLoader());
    }
}
