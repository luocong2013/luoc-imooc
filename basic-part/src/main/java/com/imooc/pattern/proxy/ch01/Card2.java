package com.imooc.pattern.proxy.ch01;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.proxy.ch01
 * @description: 使用继承方式
 * @date 2017/11/11 14:33
 */
public class Card2 extends Card {
    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        System.out.println("汽车开始行驶……");
        super.move();
        long endTime = System.currentTimeMillis();
        System.out.println("汽车结束行驶……汽车行驶时间：" + (endTime - startTime) + "ms");
    }
}
