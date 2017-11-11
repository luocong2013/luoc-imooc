package com.imooc.thread.synchroized;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.thread.synchroized
 * @description: TODO
 * @date 2017/11/11 16:42
 */
public class Bank implements Runnable {

    int money = 0;

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("会计")) {
            saveOrTake(300);
        } else if (Thread.currentThread().getName().equals("出纳")) {
            saveOrTake(150);
        }
    }

    public synchronized void saveOrTake(int amount) {
        if (Thread.currentThread().getName().equals("会计")) {
            for (int i = 1; i <= 3; i++) {
                money = money + amount / 3;
                System.out.println(Thread.currentThread().getName() + "存入" + amount / 3 + "元，帐上有" + money + "元，休息一下再存！");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if (Thread.currentThread().getName().equals("出纳")) {
            for (int i = 1; i <= 3; i++) {
                money = money - amount / 3;
                System.out.println(Thread.currentThread().getName() + "取出" + amount / 3 + "元，账上有" + money + "元，休息一下再取！");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
