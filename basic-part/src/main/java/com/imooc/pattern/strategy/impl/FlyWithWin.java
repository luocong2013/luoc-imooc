package com.imooc.pattern.strategy.impl;

import com.imooc.pattern.strategy.FlyingStragety;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.strategy.impl
 * @description: 用翅膀飞行
 * @date 2017/11/11 15:08
 */
public class FlyWithWin implements FlyingStragety {
    @Override
    public void performFly() {
        System.out.println("振翅高飞");
    }
}
