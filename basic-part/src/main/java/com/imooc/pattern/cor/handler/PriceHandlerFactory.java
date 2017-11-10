package com.imooc.pattern.cor.handler;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.cor.handler
 * @description: PriceHandler的工厂方法
 * @date 2017/11/10 20:14
 */
public class PriceHandlerFactory {
    /**
     * 创建PriceHandler的工厂方法
     *
     * @return
     */
    public static PriceHandler createPriceHandler() {
        PriceHandler sales = new Sales();
        PriceHandler lead = new Lead();
        PriceHandler man = new Manager();
        PriceHandler dir = new Director();
        PriceHandler vp = new VicePresident();
        PriceHandler ceo = new Ceo();
        sales.setSuccessor(lead);
        lead.setSuccessor(man);
        man.setSuccessor(dir);
        dir.setSuccessor(vp);
        vp.setSuccessor(ceo);
        return sales;
    }
}
