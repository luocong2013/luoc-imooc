package com.algorithm.drill.day4.ch01;

public class Exp3 {

    public static void main(String[] args) {
        int[] arr = new int[]{8, 2, 1, 0, 3, 6, 9, 5};
        int[] index = new int[]{2, 0, 4, 0, 1, 4, 3, 5, 1, 6, 7};
        String tel = "";
        for (int i : index) {
            tel += arr[i];
        }
        System.out.println("联系方式：" + tel);
    }

}
