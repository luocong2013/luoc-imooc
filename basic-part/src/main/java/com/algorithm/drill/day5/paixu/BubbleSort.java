package com.algorithm.drill.day5.paixu;

/**
 * 冒泡排序算法（升序）
 *
 * @author Luo
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {21, 55, 100, 99, 89, 90, 67, 75, 69, 87, 61};
        for (int i = 1; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
            System.out.print("第" + i + "次排序结果：");
            for (int a = 0; a < arr.length; a++) {
                System.out.print(arr[a] + "\t");
            }
            System.out.println();
        }

        System.out.print("最终排序结果为：");
        for (int b : arr) {
            System.out.print(b + "\t");
        }
    }

}
