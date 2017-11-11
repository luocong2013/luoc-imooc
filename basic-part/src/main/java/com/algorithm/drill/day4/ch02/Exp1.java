package com.luo.day4.ch02;

/**
 * 跳出多重嵌套循环
 *
 * @author Luo
 */
public class Exp1 {

    public static void main(String[] args) {
        System.out.println("-----------方法一------------");

        ok:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("i=" + i + ", j=" + j);
                if (i == 0 && j == 5) {
                    break ok;
                }
            }
        }

        System.out.println("-------------方法二----------");
        int[][] arr = {{1, 2, 3}, {4, 5, 6, 7}, {9}};
        boolean found = false;
        for (int i = 0; i < arr.length && !found; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("i=" + i + ", j=" + j);
                if (arr[i][j] == 5) {
                    found = true;
                    break;
                }
            }
        }

    }

}
