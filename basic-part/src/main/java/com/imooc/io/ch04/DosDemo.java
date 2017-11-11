package com.imooc.io.ch04;

import com.imooc.io.ch03.IoUtils;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.io.ch04
 * @description: TODO
 * @date 2017/11/11 15:51
 */
public class DosDemo {
    public static void main(String[] args) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("G:/demo/dos.dat"));
        dos.writeInt(10);
        dos.writeInt(-20);
        dos.writeLong(20L);
        dos.writeDouble(20.567);
        dos.writeFloat(99.99F);
        //采用UTF-8编码写出
        dos.writeUTF("中国红");
        //采用UTF-16be编码写出
        dos.writeChars("中国红");
        dos.close();
        IoUtils.printHex("G:/demo/dos.dat");
    }
}
