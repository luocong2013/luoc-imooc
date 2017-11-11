package com.imooc.io.ch02;

import com.imooc.io.ch03.IoUtils;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.io.ch02
 * @description: TODO
 * @date 2017/11/11 15:45
 */
public class FileOutDemo1 {
    public static void main(String[] args) throws IOException {
        //如果该文件不存在，则直接创建，如果存在，删除后创建
        FileOutputStream out = new FileOutputStream("G:/demo/out.dat");
        out.write('A');//写出了'A'的低八位
        out.write('B');//写出了'B'的低八位
        int a = 10;//write只能写八位,那么写一个int需要些4次每次8位
        out.write(a >>> 24);
        out.write(a >>> 16);
        out.write(a >>> 8);
        out.write(a);
        byte[] gbk = "中国".getBytes("gbk");
        out.write(gbk);
        out.close();

        IoUtils.printHex("G:/demo/out.dat");
    }
}
