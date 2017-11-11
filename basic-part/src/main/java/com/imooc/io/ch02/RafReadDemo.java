package com.imooc.io.ch02;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.io.ch02
 * @description: TODO
 * @date 2017/11/11 15:47
 */
public class RafReadDemo {

    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("G:/demo/raf.dat", "r");
        raf.seek(2);
        int i = 0;
        int b = raf.read();//读取一个字节
        System.out.println(raf.getFilePointer());
        i = i | (b << 24);
        b = raf.read();
        i = i | (b << 16);
        b = raf.read();
        i = i | (b << 8);
        b = raf.read();
        i = i | b;
        System.out.println(Integer.toHexString(i));
        raf.seek(2);
        i = raf.readInt();
        System.out.println(Integer.toHexString(i));
        raf.close();
    }
}
