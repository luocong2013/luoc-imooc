package com.imooc.pattern.proxy.ch01;

import java.util.Random;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.proxy.ch01
 * @description: 实现开车接口
 * @date 2017/11/11 14:32
 */
public class Card implements Moveable {
    @Override
    public void move() {
        //实现开车
        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("汽车行驶中……");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
