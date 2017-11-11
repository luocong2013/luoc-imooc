package com.imooc.pattern.proxy.ch02;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.proxy.ch02
 * @description: 汽车行驶时间记录
 * @date 2017/11/11 14:39
 */
public class CardTimeProxy implements Moveable {
    private Moveable moveable;

    public CardTimeProxy(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        System.out.println("汽车开始行驶……");
        moveable.move();
        long endTime = System.currentTimeMillis();
        System.out.println("汽车行驶结束……汽车行驶时间：" + (endTime - startTime) + "ms");
    }
}
