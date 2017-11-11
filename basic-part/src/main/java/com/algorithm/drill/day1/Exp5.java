package com.algorithm.drill.day1;

import java.io.IOException;
import java.util.Scanner;

/**
 * 题目：求s=a+aa+aaa+aaaa+aa…a的值，其中a是一个数字.
 * 例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加由键盘控制.
 *
 * @author Luo
 */
public class Exp5 {
    public static void main(String[] args) throws IOException {
        int s = 0;
        int n;
        int t = 0;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        n = Integer.parseInt(input);
        for (int i = 1; i <= n; i++) {
            t = t * 10 + n;
            s = s + t;
            System.out.println(t);
        }
        System.out.println(s);
    }
}
