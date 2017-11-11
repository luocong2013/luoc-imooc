package com.luo.day4.ch02;

public class Exp3 {

    public static int staticVar = 0;
    public int instanceVar = 0;
    public static final int VALUE_T = 80;

    public Exp3() {
        staticVar++;
        instanceVar++;
        System.out.println("staticVar=" + staticVar + "\tinstanceVar=" + instanceVar);
    }

    public static void main(String[] args) {
        new Exp3();
        new Exp3();
        new Exp3();
        new Exp3();
        new Exp3();
        new Exp3();
        new Exp3();
    }

}
