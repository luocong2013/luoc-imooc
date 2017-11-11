package com.imooc.io.ch03;

import java.io.IOException;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.io.ch03
 * @description: TODO
 * @date 2017/11/11 15:49
 */
public class IoUtilsTest1 {

    public static void main(String[] args) {
        try {
            long start = System.currentTimeMillis();
//			IoUtils.printHex("F:\\Java\\java面试宝典.pdf");//运行时间：7464ms
            IoUtils.printHexByByteArray("F:\\Java\\java面试宝典.pdf");//运行时间：3935ms
            long end = System.currentTimeMillis();
            System.out.println();
            System.out.print("运行时间：" + (end - start) + "ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
