package com.imooc.annotation.ch04;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.annotation.ch04
 * @description: 测试类
 * @date 2017/11/9 22:20
 */
public class Client {

    public static void main(String[] args) {
        try {
            //1. 使用类加载器加载
            Class<?> tCls = Class.forName("com.imooc.annotation.ch04.TestAnno");
            //2. 找到类上面的注解
            boolean isExist = tCls.isAnnotationPresent(Description.class);
            if (isExist) {
                //3.拿到注解实例
                Description d = tCls.getAnnotation(Description.class);
                System.out.println(d.desc());
                System.out.println(d.age());
            }

            //4. 找到方法上的注解
            Method[] ms = tCls.getMethods();
            for (Method m : ms) {
                boolean isMExist = m.isAnnotationPresent(Description.class);
                if (isMExist) {
                    Description md = m.getAnnotation(Description.class);
                    System.out.println(md.desc());
                    System.out.println(md.age());
                }
            }
            //另外一种解析方法
            System.out.println("---------------方法二----------------");
            for (Method m : ms) {
                Annotation[] as = m.getAnnotations();
                for (Annotation a : as) {
                    if (a instanceof Description) {
                        Description md = (Description) a;
                        System.out.println(md.desc());
                        System.out.println(md.age());
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
