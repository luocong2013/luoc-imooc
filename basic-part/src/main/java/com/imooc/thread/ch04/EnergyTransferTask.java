package com.imooc.thread.ch04;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.thread.ch04
 * @description: TODO
 * @date 2017/11/11 16:39
 */
public class EnergyTransferTask implements Runnable {

    /**
     * 享的能量世界
     */
    private EnergySystem energySystem;
    /**
     * 能量转移的源能量盒子下标
     */
    private int fromBox;
    /**
     * 单次能量转移最大单元
     */
    private double maxAmount;
    /**
     * 最大休眠时间（毫秒）
     */
    private int DELAY = 10;

    public EnergyTransferTask(EnergySystem energySystem, int fromBox, double maxAmount) {
        this.energySystem = energySystem;
        this.fromBox = fromBox;
        this.maxAmount = maxAmount;
    }

    @Override
    public void run() {
        while (true) {
            int toBox = (int) (energySystem.getBoxAmount() * Math.random());
            double amount = maxAmount * Math.random();
            energySystem.transfer(fromBox, toBox, amount);
            try {
                Thread.sleep((int) (DELAY * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
