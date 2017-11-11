package com.imooc.io.ch04;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.io.ch04
 * @description: TODO
 * @date 2017/11/11 15:51
 */
public class DisDemo {

    public static void main(String[] args) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("G:/demo/dos.dat"));
        int i = dis.readInt();
        System.out.println(i);
        i = dis.readInt();
        System.out.println(i);
        long L = dis.readLong();
        System.out.println(L);
        double d = dis.readDouble();
        System.out.println(d);
        float f = dis.readFloat();
        System.out.println(f);
        String s = dis.readUTF();
        System.out.println(s);
        dis.close();
    }
}
