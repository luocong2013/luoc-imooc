package com.imooc.reflect.ch02;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.reflect.ch02
 * @description: TODO
 * @date 2017/11/11 16:00
 */
public class ClassDemo2 {
    public static void main(String[] args) {
        //int的类类型
        Class<?> c1 = int.class;
        //String类的类类型
        Class<?> c2 = String.class;
        Class<?> c3 = double.class;
        Class<?> c4 = Double.class;
        Class<?> c5 = void.class;

        System.out.println(c1.getName());
        System.out.println(c2.getName());
        System.out.println(c2.getSimpleName());
        System.out.println(c3.getName());
        System.out.println(c4.getName());
        System.out.println(c5.getName());
    }
}
