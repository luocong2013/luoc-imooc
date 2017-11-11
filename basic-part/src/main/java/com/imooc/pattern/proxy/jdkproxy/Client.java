package com.imooc.pattern.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.proxy.jdkproxy
 * @description: 测试类
 * @date 2017/11/11 14:56
 */
public class Client {
    public static void main(String[] args) {
        //我们要代理的真实对象
        Card card = new Card();
        //我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        InvocationHandler handler = new TimeHandler(card);
        Class<?> cls = card.getClass();
        /**
         * 动态代理实现思路
         * 实现功能：通过Proxy的newProxyInstance返回代理对象
         * 1、声明一段源码（动态产生代理）
         * 2、编译源码（JDK Compiler API），产生新的类（代理类）
         * 3、将这个类load到内存当中，产生一个新的对象（代理对象）
         * 4、return 代理对象
         *
         * loader  类加载器（定义了由哪个ClassLoader对象来对生成的代理对象进行加载）
         * interfaces  实现接口（表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了）
         * handler  InvocationHandler（表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上）
         */
        Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), handler);
        System.out.println(m.getClass().getSimpleName());
        /**
         * 当我们通过代理对象调用一个方法的时候，
         * 这个方法的调用就会被转发为由InvocationHandler这个接口的 invoke 方法来进行调用
         */
        m.move();

        m.stop("布加迪");
    }
}
