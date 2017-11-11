package com.algorithm.drill.day1;

/**
 * 题目：打印出所有的“水仙花数”，所谓“水仙花数”是指一个三位数，其各位数字
 * 立方和等于该数本身。例如：153是一个“水仙花数”，因为153=1^3+5^3+3^3.
 *
 * @author Luo
 */
public class Exp3 {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            if (isshuixianhuashu(i)) {
                System.out.println(i);
            }
        }
    }


    public static boolean isshuixianhuashu(int x) {
        int baiwei = x / 100;
        int siwei = (x % 100) / 10;
        int gewei = x % 10;
        return x == Math.pow(baiwei, 3) + Math.pow(siwei, 3) + Math.pow(gewei, 3);
    }

}
