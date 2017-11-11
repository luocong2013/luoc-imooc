package com.algorithm.drill.day4.ch01;

public class Exp1 {

    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "he" + new String("llo");
        String str3 = new String("hello");
        String str4 = "hello";
        System.err.println(str1 == str2);//false
        System.err.println(str1 == str3);//false
        System.err.println(str1 == str4);//true
        System.err.println(str1.equals(str2));//true
        System.err.println(str1.equals(str3));//true
    }

}
