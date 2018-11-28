package com.classloader;

/**
 * @author luoc
 * @version V1.0.0
 * @description ClassLoader测试用例
 * @date 2018/11/28 21:31
 */
public class TestCase {

    public static void main(String[] args) throws Exception {
        CustomizeClassLoader luocLoader = new CustomizeClassLoader("luoc", "D:/test/");
        CustomizeClassLoader loader = new CustomizeClassLoader(null, "zs", "D:/test/");
        Class<?> clazz = loader.loadClass("com.classloader.Demo");
        clazz.newInstance();
    }
}
