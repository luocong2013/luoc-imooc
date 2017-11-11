package com.imooc.pattern.proxy.cglibproxy;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.proxy.cglibproxy
 * @description: 测试类
 * @date 2017/11/11 15:00
 */
public class Client {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        Train t = (Train) proxy.getProxy(Train.class);
        t.move();
    }
}
