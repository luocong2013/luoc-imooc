package com.imooc.pattern.strategy.impl;

import com.imooc.pattern.strategy.FlyingStragety;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.strategy.impl
 * @description: 用火箭飞行
 * @date 2017/11/11 15:07
 */
public class FlyWithRocket implements FlyingStragety {
    @Override
    public void performFly() {
        System.out.println("用火箭在太空遨游");
    }
}
