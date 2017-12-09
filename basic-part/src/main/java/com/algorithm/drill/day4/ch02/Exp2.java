package com.algorithm.drill.day4.ch02;

public class Exp2 {

    public static void main(String[] args) {
        int number = 10;
        //原始数二进制
        printInfo(number);

        //左移一位
        number = number << 1;
        printInfo(number);

        //右移一位
        number = number >> 1;
        printInfo(number);

        //无符号右移二位
        number = number >>> 2;
        printInfo(number);
    }

    private static void printInfo(int num) {
        System.out.println("二进制数：" + Integer.toBinaryString(num) + "\t十进制数" + num);
    }

}
