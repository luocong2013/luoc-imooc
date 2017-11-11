package com.imooc.reflect.ch05;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.reflect.ch05
 * @description: TODO
 * @date 2017/11/11 16:07
 */
public class MethodDemo4 {
    public static void main(String[] args) {
        ArrayList<?> list = new ArrayList<>();

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("luo");
        Class<?> c1 = list.getClass();
        Class<?> c2 = list2.getClass();
        System.out.println(c1 == c2);
        //反射操作都是编译之后的操作

        /**
         * c1==c2结果返回true说明编译之后集合的泛型是去泛型化的
         * Java中集合的泛型，是防止错误输入的，只在编译阶段有效，
         * 绕过编译就无效了
         * 验证：我们可以通过方法的反射来操作，绕过编译
         */
        try {
            Method m2 = c2.getMethod("add", Object.class);
            Object obj = m2.invoke(list2, 20);//绕过编译操作就绕过了泛型
            System.out.println(obj);
            System.out.println(list2.size());
            Object[] objects = list2.toArray();
            for (Object object : objects) {
                System.out.println(object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
