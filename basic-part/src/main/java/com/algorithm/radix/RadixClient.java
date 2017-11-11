package com.algorithm.radix;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.algorithm.radix
 * @description: TODO
 * @date 2017/11/11 17:18
 */
public class RadixClient {

    public static void main(String[] args) {
        int numA = 51;
        int numB = 5;
        printInfo(numA);
        printInfo(numB);
        System.out.println("numA & numB：" + (numA & numB));
        System.out.println("numA | numB：" + (numA | numB));
        System.out.println("numA ^ numB：" + (numA ^ numB));
        System.out.println("~numA：" + (~numA));

        printInfo(65);
        printInfo(31);
        printInfo((-49 & 0xff) << 0);
        printInfo(0x7fffffff);
    }

    private static void printInfo(int num) {
        System.out.println("二进制数：" + Integer.toBinaryString(num) + "\t十进制数：" + num);
    }
}
