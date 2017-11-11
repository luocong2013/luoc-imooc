package com.imooc.pattern.proxy.ch05;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.proxy.ch05
 * @description: 测试类
 * @date 2017/11/11 14:49
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Card card = new Card();
        InvocationHandler h = new TimeHandler(card);
        Moveable m = (Moveable) Proxy.newProxyInstance(Moveable.class, h);
        m.move();
    }
}
