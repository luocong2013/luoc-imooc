package com.luo.day4.ch02;

public class Exp4 {

    public static void main(String[] args) {
        int a = 4;
        System.out.println(a);//4
        a += (a++);
        System.out.println(a);//8
        a += (++a);
        System.out.println(a);//17

        System.out.println(Math.floor(11.95999999));//11.0
        System.out.println(Math.round(11.4599999));//11
        System.out.println(Math.round(11.50000000));//12

    }

}
