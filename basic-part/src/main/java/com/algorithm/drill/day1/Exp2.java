package com.algorithm.drill.day1;

/**
 * 题目：判断1-200之间有多少个素数，并输出所有素数。
 * ***程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)
 * 如果能被整除，则表明此数不是素数，反之是素数。
 *
 * @author Luo
 */
public class Exp2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 200; i++) {
            if (issushu(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean issushu(int x) {
        if (x == 1 || x == 2) {
            return true;
        } else {
            for (int i = 2; i <= Math.sqrt(x); i++) {
                if (x % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }


}
