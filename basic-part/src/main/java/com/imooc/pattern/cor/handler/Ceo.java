package com.imooc.pattern.cor.handler;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.cor.handler
 * @description: CEO， 可以批准55%以内的折扣 折扣超出55%， 就拒绝申请
 * @date 2017/11/10 20:13
 */
public class Ceo extends PriceHandler {
    @Override
    public void processDiscount(float discount) {
        if (discount <= 0.55f) {
            System.out.format("%s批准了折扣:%.2f%n", this.getClass().getName(), discount);
        } else {
            System.out.format("%s拒绝了折扣:%.2f%n", this.getClass().getName(), discount);
        }
    }
}
