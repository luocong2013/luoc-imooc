package com.classloader;

/**
 * @author luoc
 * @version V1.0.0
 * @description ClassLoader测试2
 * @date 2018/11/28 21:06
 */
public class Demo2 {

    public static void main(String[] args) {
        ClassLoader loader = Demo2.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader);
            loader = loader.getParent();
        }
        System.out.println(loader);
    }
}
