package com.algorithm.drill.day3.proxy;

public class Test {

    public static void main(String[] args) {
        Hello proxy = new HelloProxy(new HelloSpeaker1());
        proxy.hello("罗聪");
    }

}
