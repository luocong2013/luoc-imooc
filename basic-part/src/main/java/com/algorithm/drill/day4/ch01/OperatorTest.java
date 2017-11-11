package com.algorithm.drill.day4.ch01;

public class OperatorTest {

    public static void main(String[] args) {
        int a = 12, b = 8, c = 6;
        System.out.println(a + " " + b + " " + c);//12 8 6
        a = c;
        System.out.println(a + " " + b + " " + c);//6 8 6
        c += b;
        System.out.println(a + " " + b + " " + c);//6 8 14
        a = b + c;
        System.out.println(a + " " + b + " " + c);//22 8 14
        a++;
        ++b;
        c = a++ + ++b;
        System.out.println(a + " " + b + " " + c);//24 10 33

        int num1 = 5, num2 = 8;
        int sum;
        sum = num1++ + num2++;
        System.out.println(sum);//13
        sum = num1++ + ++num2;
        System.out.println(sum);//16
        sum = ++num1 + num2++;
        System.out.println(sum);//18
        sum = ++num1 + ++num2;
        System.out.println(sum);//21

        int x = 0;
        boolean boo = x == 0 || x++ == 0;
        System.out.println(boo);//true
        System.out.println(x);//0
    }

}
