package com.imooc.reflect.ch02;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.reflect.ch02
 * @description: TODO
 * @date 2017/11/11 16:01
 */
public class ClassDemo3 {
    public static void main(String[] args) {
        String str = "Luo";
        ClassUtil.printClassMethodMsg(str);
        System.out.println("========================================");
        Integer int1 = 20;
        ClassUtil.printClassMethodMsg(int1);
    }
}
