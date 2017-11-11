package com.imooc.reflect.ch04;

import java.lang.reflect.Method;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.reflect.ch04
 * @description: TODO
 * @date 2017/11/11 16:03
 */
public class MethodDemo1 {
    public static void main(String[] args) throws Exception {
        /**
         * 要获取print(int ,int )方法
         * 1.要获取一个方法就是获取类的信息，获取类的信息首先要获取类的类类型
         */
        A a1 = new A();
        Class<?> c1 = a1.getClass();
        /**
         * 2.获取方法 名称和参数列表来决定
         * getMethod获取的是public的方法
         * getDelcaredMethod自己声明的方法
         */
        //Method m1 = c1.getMethod("print", new Class[]{int.class, int.class});
        Method m1 = c1.getMethod("print", int.class, int.class);

        //方法的反射操作
        //a1.print(10, 20);方法的反射操作是用m1对象来进行方法调用 和a1.print调用的效果完全相同
        //方法如果没有返回值返回null,有返回值返回具体的返回值
        //Object obj = m1.invoke(a1, new Object[]{10, 20});
        Object obj = m1.invoke(a1, 10, 20);
        System.out.println(obj);
        System.out.println("==================");
        //获取方法print(String,String)
        Method m2 = c1.getMethod("print", String.class, String.class);
        //用方法进行反射操作
        obj = m2.invoke(a1, "hello", "WORLD");
        System.out.println(obj);
        System.out.println("==================");
        //Method m3 = c1.getMethod("print", new Class[]{});
        //m3.invoke(a1, new Object[]{});
        Method m3 = c1.getMethod("print");
        m3.invoke(a1);
    }
}

class A {
    public void print() {
        System.out.println("Hello World！");
    }

    public int print(int a, int b) {
        System.out.println(a + b);
        return (a + b) * 20;
    }

    public void print(String a, String b) {
        System.out.println(a.toUpperCase() + "," + b.toLowerCase());
    }
}
