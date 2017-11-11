package com.algorithm.drill.day3.proxy;

/**
 * 实现接口的业务逻辑类
 *
 * @author Luo
 */
public class HelloSpeaker1 implements Hello {

    @Override
    public void hello(String name) {
        System.out.println("hello," + name);
    }

}
