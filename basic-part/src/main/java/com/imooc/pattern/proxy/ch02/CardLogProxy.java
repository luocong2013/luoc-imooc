package com.imooc.pattern.proxy.ch02;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.proxy.ch02
 * @description: 汽车日志记录
 * @date 2017/11/11 14:38
 */
public class CardLogProxy implements Moveable {
    private Moveable moveable;

    public CardLogProxy(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public void move() {
        System.out.println("日志开始……");
        moveable.move();
        System.out.println("日志结束……");
    }
}
