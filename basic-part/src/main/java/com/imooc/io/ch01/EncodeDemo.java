package com.imooc.io.ch01;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.io.ch01
 * @description: 编码
 * @date 2017/11/11 15:34
 */
public class EncodeDemo {
    public static void main(String[] args) throws Exception {
        String s = "慕课ABC";
        byte[] bytes1 = s.getBytes();//平台的默认编码UTF-8，汉字3个字节，字母1个字节
        for (byte c : bytes1) {
            System.out.print(Integer.toHexString(c & 0xff) + "  ");
        }
        System.out.println();
        for (byte b : bytes1) {
            System.out.print(b + "  ");
        }
        System.out.println();
        byte[] bytes2 = s.getBytes("gbk");//汉字2个字节，字母1个字节
        for (byte c : bytes2) {
            System.out.print(Integer.toHexString(c & 0xff) + "  ");
        }
        System.out.println();
        byte[] bytes3 = s.getBytes("utf-16be");//汉字2个字节，字母2个字节
        for (byte b : bytes3) {
            System.out.print(Integer.toHexString(b & 0xff) + "  ");
        }
    }
}
