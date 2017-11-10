package com.imooc.pattern.cor;

import com.imooc.pattern.cor.handler.PriceHandler;
import com.imooc.pattern.cor.handler.PriceHandlerFactory;

import java.util.Random;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.pattern.cor
 * @description: 责任链模式  客户，请求折扣
 * @date 2017/11/10 20:15
 */
public class Customer {
    private PriceHandler priceHandler;

    public void setPriceHandler(PriceHandler priceHandler) {
        this.priceHandler = priceHandler;
    }

    public void requestDiscount(float discount) {
        priceHandler.processDiscount(discount);
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setPriceHandler(PriceHandlerFactory.createPriceHandler());
        Random rand = new Random();
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + ":");
            customer.requestDiscount(rand.nextFloat());
        }
    }
}
