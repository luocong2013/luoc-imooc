package com.imooc.pattern.proxy.jdkproxy;

import java.util.Random;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.proxy.jdkproxy
 * @description: 实现开车接口
 * @date 2017/11/11 14:54
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

    @Override
    public void stop(String name) {
        System.out.println("汽车停止：" + name);
    }
}
