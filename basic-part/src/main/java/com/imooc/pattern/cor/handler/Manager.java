package com.imooc.pattern.cor.handler;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.cor.handler
 * @description: 销售经理， 可以批准30%以内的折扣
 * @date 2017/11/10 20:12
 */
public class Manager extends PriceHandler {
    @Override
    public void processDiscount(float discount) {
        if (discount <= 0.3f) {
            System.out.format("%s批准了折扣:%.2f%n", this.getClass().getName(), discount);
        } else {
            successor.processDiscount(discount);
        }
    }
}
