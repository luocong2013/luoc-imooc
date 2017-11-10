package com.imooc.pattern.cor.handler;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.cor.handler
 * @description: 销售副总裁， 可以批准50%以内的折扣
 * @date 2017/11/10 20:13
 */
public class VicePresident extends PriceHandler {
    @Override
    public void processDiscount(float discount) {
        if (discount <= 0.5f) {
            System.out.format("%s批准了折扣:%.2f%n", this.getClass().getName(), discount);
        } else {
            successor.processDiscount(discount);
        }
    }
}
