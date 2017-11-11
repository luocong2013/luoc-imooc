package com.imooc.pattern.proxy.ch02;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.proxy.ch02
 * @description: 测试类
 * @date 2017/11/11 14:40
 */
public class Client {
    public static void main(String[] args) {
        Card card = new Card();
        CardLogProxy clp = new CardLogProxy(card);
        CardTimeProxy ctp = new CardTimeProxy(clp);
        ctp.move();
    }
}
