package com.imooc.thread.ch03;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.thread.ch03
 * @description: interrupt()方法不能使线程退出
 * @date 2017/11/11 16:37
 */
public class WrongWayStopThread extends Thread {

    public static void main(String[] args) throws InterruptedException {
        WrongWayStopThread thread = new WrongWayStopThread();
        System.out.println("Starting thread……");
        thread.start();
        Thread.sleep(3000);
        System.out.println("Interrupting thread……");
        thread.interrupt();
        Thread.sleep(3000);
        System.out.println("Stopping application……");
    }

    @SuppressWarnings("static-access")
    @Override
    public void run() {
        while (!this.interrupted()) {
            System.out.println("Thread is Running……");
//			long time = System.currentTimeMillis();
//			while (System.currentTimeMillis()-time < 1000) {
//
//			}
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
