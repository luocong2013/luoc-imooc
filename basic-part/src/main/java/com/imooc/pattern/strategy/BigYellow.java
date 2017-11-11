package com.imooc.pattern.strategy;

import com.imooc.pattern.strategy.impl.FlyNoWay;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.strategy
 * @description: TODO
 * @date 2017/11/11 15:06
 */
public class BigYellow extends Duck {
    public BigYellow() {
        super.setFlyingStragety(new FlyNoWay());
    }

    @Override
    public void display() {
        System.out.println("我身体很大，全身黄黄");
    }
}
