package com.imooc.pattern.strategy;

import com.imooc.pattern.strategy.impl.FlyWithWin;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.strategy
 * @description: TODO
 * @date 2017/11/11 15:10
 */
public class RedheadDuck extends Duck {
    public RedheadDuck() {
        super.setFlyingStragety(new FlyWithWin());
    }

    @Override
    public void display() {
        System.out.println("我的头是红色的");
    }
}
