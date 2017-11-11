package com.imooc.pattern.strategy;

import com.imooc.pattern.strategy.impl.FlyWithRocket;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.strategy
 * @description: TODO
 * @date 2017/11/11 15:12
 */
public class SpaceDuck extends Duck {
    public SpaceDuck() {
        super.setFlyingStragety(new FlyWithRocket());
    }

    @Override
    public void display() {
        System.out.println("我头戴宇航头盔");
    }

    @Override
    public void quack() {
        System.out.println("我通过无线电与你通信");
    }
}
