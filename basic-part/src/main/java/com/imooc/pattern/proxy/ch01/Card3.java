package com.imooc.pattern.proxy.ch01;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.proxy.ch01
 * @description: 使用聚合方式实现
 * @date 2017/11/11 14:34
 */
public class Card3 implements Moveable {
    private Card card;

    public Card3(Card card) {
        this.card = card;
    }

    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        System.out.println("汽车开始行驶……");
        card.move();
        long endTime = System.currentTimeMillis();
        System.out.println("汽车结束行驶……汽车行驶时间：" + (endTime - startTime) + "ms");
    }
}
