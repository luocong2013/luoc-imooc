package com.imooc.io.ch03;

import java.io.*;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.io.ch03
 * @description: TODO
 * @date 2017/11/11 15:48
 */
public class IoUtils {

    /**
     * 读取指定文件内容，安照16进制输出到控制台
     * 并且没输出10个byte换行
     * 单字节读取不适合大文件，大文件效率很低
     *
     * @param fileName
     * @throws IOException
     */
    public static void printHex(String fileName) throws IOException {
        //把文件作为字节流进行读操作
        FileInputStream in = new FileInputStream(fileName);
        int b;
        int i = 1;
        while ((b = in.read()) != -1) {
            System.out.print(Integer.toHexString(b & 0xff) + "\t");
            if (i++ % 10 == 0) {
                System.out.println();
            }
        }
        in.close();
    }

    /**
     * 批量读取，对大文件而言效率高，也是我们最常用的读文件的方式
     *
     * @param fileName
     * @throws IOException
     */
    public static void printHexByByteArray(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        byte[] buf = new byte[8 * 1024];
        /**
         * 从in中批量读取字节，放入到buf这个字节数组中，
         * 从第0个位置开始放，最多放buf.length个
         * 返回的是读到的字节的个数
         */
        int bytes = 0;
        int j = 1;
        while ((bytes = in.read(buf)) != -1) {
            for (int i = 0; i < bytes; i++) {
                System.out.print(Integer.toHexString(buf[i] & 0xff) + "\t");
                if (j++ % 10 == 0) {
                    System.out.println();
                }
            }
        }
        in.close();
    }

    /**
     * 文件拷贝，字节批量读取
     *
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFile(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文件:" + srcFile + "不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);
        byte[] buf = new byte[8 * 1024];
        int b;
        while ((b = in.read(buf, 0, buf.length)) != -1) {
            out.write(buf, 0, b);
            out.flush();//最好加上
        }
        in.close();
        out.close();
    }

    /**
     * 进行文件的拷贝，利用带缓冲的字节流
     *
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFileByBuffer(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文件:" + srcFile + "不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
        int c;
        while ((c = bis.read()) != -1) {
            bos.write(c);
            bos.flush();//刷新缓冲区
        }
        bis.close();
        bos.close();
    }

    /**
     * 进行文件的拷贝，利用带缓冲的字节流且字节批量读取
     *
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFileByBufferAndP(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文件:" + srcFile + "不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
        int c;
        byte[] buf = new byte[8 * 1024];
        while ((c = bis.read(buf, 0, buf.length)) != -1) {
            bos.write(buf, 0, c);
            bos.flush();//刷新缓冲区
        }
        bis.close();
        bos.close();
    }

    /**
     * 单字节，不带缓冲进行文件拷贝
     *
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFileByByte(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文件:" + srcFile + "不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);
        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
            out.flush();
        }
        in.close();
        out.close();
    }
}
