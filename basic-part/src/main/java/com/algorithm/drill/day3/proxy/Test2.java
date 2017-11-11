package com.algorithm.drill.day3.proxy;

import java.lang.reflect.Proxy;

@SuppressWarnings("all")
public class Test2 {

    public static void main(String[] args) {
        HelloSpeaker1 helloSpeaker = new HelloSpeaker1();
        LogHandler logHandler = new LogHandler(helloSpeaker);
        Class cla = helloSpeaker.getClass();
        Hello hello = (Hello) Proxy.newProxyInstance(cla.getClassLoader(), cla.getInterfaces(), logHandler);
        hello.hello("小强");
    }
}
