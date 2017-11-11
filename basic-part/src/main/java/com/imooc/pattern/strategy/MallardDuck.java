package com.imooc.pattern.strategy;

import com.imooc.pattern.strategy.impl.FlyWithWin;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.strategy
 * @description: TODO
 * @date 2017/11/11 15:08
 */
public class MallardDuck extends Duck {
    public MallardDuck() {
        super.setFlyingStragety(new FlyWithWin());
    }

    @Override
    public void display() {
        System.out.println("我的脖子是绿色的");
    }
}
