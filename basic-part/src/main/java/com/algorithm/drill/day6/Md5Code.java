package com.algorithm.drill.day6;

import java.security.MessageDigest;

/**
 * Java的MD5加密实现代码
 *
 * @author Luo
 */
public class Md5Code {

    public static String Md5(String plainText) {
        System.out.println("加密前：" + plainText);
        try {
            //生成实现指定摘要算法的MessageDigest对象
            MessageDigest mDigest = MessageDigest.getInstance("MD5");
            //使用指定的字节数组更新摘要
            mDigest.update(plainText.getBytes());
            //通过执行诸如填充之类的最终操作完成哈希计算
            byte[] b = mDigest.digest();
            int i;
            StringBuffer buffer = new StringBuffer();
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buffer.append("0");
                }
                buffer.append(Integer.toHexString(i));
            }
            System.out.println("加密后：" + buffer.toString());
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return plainText;
    }


    public static void main(String[] args) {
        String plainText = "123456";
        Md5Code.Md5(plainText);
        //e10adc3949ba59abbe56e057f20f883e
    }

}
