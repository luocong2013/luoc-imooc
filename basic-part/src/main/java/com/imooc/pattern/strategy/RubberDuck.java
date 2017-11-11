package com.imooc.pattern.strategy;

import com.imooc.pattern.strategy.impl.FlyNoWay;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.strategy
 * @description: TODO
 * @date 2017/11/11 15:11
 */
public class RubberDuck extends Duck {
    public RubberDuck() {
        super.setFlyingStragety(new FlyNoWay());
    }

    @Override
    public void display() {
        System.out.println("我全身发黄，嘴巴很红");
    }

    @Override
    public void quack() {
        System.out.println("嘎~嘎~嘎~");
    }
}
