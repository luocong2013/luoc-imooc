package com.imooc.thread.ch02;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.thread.ch02
 * @description: 军队线程 模拟作战双方的行为
 * @date 2017/11/11 16:35
 */
public class ArmyRunnable implements Runnable {
    /**
     * volatile保证了线程可以正确的读取其他线程写入的值
     */
    volatile boolean keepRunning = true;

    @Override
    public void run() {
        while (keepRunning) {
            //发动5连击
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "进攻对方[" + i + "]次");
                //让出了处理器的时间，下次该谁进攻还不一定
                Thread.yield();
            }
        }

        System.out.println(Thread.currentThread().getName() + "战斗结束了！");
    }
}
