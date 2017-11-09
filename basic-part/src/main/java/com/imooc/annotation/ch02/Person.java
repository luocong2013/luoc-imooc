package com.imooc.annotation.ch02;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.annotation.ch02
 * @description: TODO
 * @date 2017/11/9 22:11
 */
public interface Person {
    String name();

    int age();

    /**
     * 注释：表示该方法已过时了
     */
    @Deprecated
    void sing();
}
