package com.imooc.pattern.proxy.ch01;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.proxy.ch01
 * @description: 测试类
 * @date 2017/11/11 14:35
 */
public class Client {
    public static void main(String[] args) {
//		Card card = new Card();
//		card.move();
        //使用继承方式
//		Moveable m = new Card2();
//		m.move();
        //使用聚合方式实现
        Card card = new Card();
        Moveable m = new Card3(card);
        m.move();
    }
}
