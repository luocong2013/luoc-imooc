package com.algorithm.basic;

import java.util.Random;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.algorithm.basic
 * @description: TODO
 * @date 2017/11/11 17:24
 */
public class HelloWorld3 {
    private static Random random = new Random();

    public static void main(String[] args) {

        // 定义一个整型数组，长度为10
        int[] nums = new int[10];

        //通过循环给数组赋值
        for (int i = 0; i < nums.length; i++) {
            // 产生10以内的随机数
            int x = random.nextInt(10);

            // 为元素赋值
            nums[i] = x;
        }

        // 使用foreach循环输出数组中的元素
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
