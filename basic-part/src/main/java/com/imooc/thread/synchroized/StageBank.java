package com.imooc.thread.synchroized;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.thread.synchroized
 * @description: TODO
 * @date 2017/11/11 16:43
 */
public class StageBank {

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.setMoney(500);

        Thread accountant = new Thread(bank, "会计");
        Thread cashier = new Thread(bank, "出纳");

        accountant.start();
        cashier.start();
    }
}
