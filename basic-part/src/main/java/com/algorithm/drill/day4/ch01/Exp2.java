package com.algorithm.drill.day4.ch01;

public class Exp2 {

    public static void haha() {
        System.out.println("haha");
    }

    /**
     * null值可以强制转换为任何java类类型,(String)null也是合法的
     *
     * @param args
     */
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        ((Exp2) null).haha();
    }

}
