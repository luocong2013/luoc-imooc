package com.imooc.thread.ch02;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.thread.ch02
 * @description: TODO
 * @date 2017/11/11 16:34
 */
public class KeyPersonThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始战斗了！");
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "左突右杀，攻击隋军……");
        }
        System.out.println(Thread.currentThread().getName() + "战斗结束了！");
    }
}
