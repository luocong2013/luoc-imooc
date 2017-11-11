package com.imooc.thread.ch01;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.thread.ch01
 * @description: TODO
 * @date 2017/11/11 16:30
 */
public class Exp1 {

    static {
        System.out.println("static");
    }

    static void pong() {
        System.out.println("pong");
    }


    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            pong();
            System.out.println(1);
        });

        Thread thread = new Thread() {

            @Override
            public void run() {
                pong();
                System.out.println(2);
            }

        };
        t.start();
        thread.run();//调用run()方法，并未启动线程
        System.out.println("ping");
    }
}
