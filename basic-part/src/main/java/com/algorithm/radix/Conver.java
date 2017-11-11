package com.algorithm.radix;

import java.util.Arrays;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.algorithm.radix
 * @description: TODO
 * @date 2017/11/11 17:17
 */
public class Conver {
    /**
     * int 转换为 bytes
     *
     * @param id
     * @return
     */
    public static byte[] int2Bytes(int id) {
        byte[] arr = new byte[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (byte) (id >> i * 8 & 0xff);
        }
        return arr;
    }

    /**
     * bytes 转换为 int
     *
     * @param arr
     * @return
     */
    public static int bytes2Int(byte[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += (arr[i] & 0xff) << i * 8;
        }
        return result;
    }

    public static void main(String[] args) {
        int numA = 8143;
        byte[] arr = Conver.int2Bytes(numA);
        System.out.println(Arrays.toString(arr));
        System.out.println(Conver.bytes2Int(arr));
    }
}
