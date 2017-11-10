package com.imooc.pattern.cor.handler;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.cor.handler
 * @description: 价格处理人，负责处理客户折扣申请
 * @date 2017/11/10 20:07
 */
public abstract class PriceHandler {
    /**
     * 直接后继，用于传递请求
     */
    protected PriceHandler successor;

    public void setSuccessor(PriceHandler successor) {
        this.successor = successor;
    }

    /**
     * 处理折扣申请
     * @param discount
     */
    public abstract void processDiscount(float discount);
}
