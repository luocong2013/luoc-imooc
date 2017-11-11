package com.imooc.io.ch03;

import java.io.File;
import java.io.IOException;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.io.ch03
 * @description: TODO
 * @date 2017/11/11 15:50
 */
public class IoUtilsTest2 {
    public static void main(String[] args) {
        try {
            long start = System.currentTimeMillis();
//			IOUtils.copyFile(new File("F:\\Java\\java面试宝典.pdf"), new File("F:\\Java\\1.pdf"));//运行时间：15ms
//			IOUtils.copyFileByBuffer(new File("F:\\Java\\java面试宝典.pdf"), new File("F:\\Java\\2.pdf"));//运行时间：2776ms
//			IOUtils.copyFileByBufferAndP(new File("F:\\Java\\java面试宝典.pdf"), new File("F:\\Java\\3.pdf"));//运行时间：16ms
            IoUtils.copyFileByByte(new File("F:\\Java\\java面试宝典.pdf"), new File("F:\\Java\\4.pdf"));//运行时间：4181ms
            long end = System.currentTimeMillis();
            System.out.print("运行时间：" + (end - start) + "ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
