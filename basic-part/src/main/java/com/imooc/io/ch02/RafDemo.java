package com.imooc.io.ch02;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.io.ch02
 * @description: TODO
 * @date 2017/11/11 15:47
 */
public class RafDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("G:/demo");
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, "raf.dat");
        if (!file2.exists()) {
            file2.createNewFile();
        }

        RandomAccessFile raf = new RandomAccessFile(file2, "rw");
        //指针位置
        System.out.println(raf.getFilePointer());
        raf.write('A');//只写了一个字节
        System.out.println(raf.getFilePointer());
        raf.write('B');

        int i = 0x7fffffff;//最大的int型整数
        //用write方法每次只能写一个字节，如果要把i写进去就得写4次
        raf.write(i >>> 24);//高8位
        raf.write(i >>> 16);
        raf.write(i >>> 8);
        raf.write(i);
        System.out.println(raf.getFilePointer());


        //可以直接写入一个int
        raf.writeInt(i);
        System.out.println(raf.getFilePointer());

        String s = "罗";
        byte[] gbk = s.getBytes("gbk");
        raf.write(gbk);
        System.out.println(raf.getFilePointer());
        System.out.println(raf.length());

        //读文件，必须把指针移到头部
        raf.seek(0);
        //一次性读取,把文件中的内容都读到字节数组中
        byte[] buf = new byte[(int) raf.length()];
        raf.read(buf);

        System.out.println(Arrays.toString(buf));
        for (byte b : buf) {
            System.out.print(Integer.toHexString(b & 0xff) + "\t");
        }
        raf.close();
    }
}
