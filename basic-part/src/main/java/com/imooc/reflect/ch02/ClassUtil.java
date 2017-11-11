package com.imooc.reflect.ch02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.reflect.ch02
 * @description: TODO
 * @date 2017/11/11 15:59
 */
public class ClassUtil {
    /**
     * 打印类的信息，包括类的成员函数、成员变量(只获取成员函数)
     *
     * @param obj 该对象所属类的信息
     */
    public static void printClassMethodMsg(Object obj) {
        //要获取类的信息  首先要获取类的类类型
        Class<?> c1 = obj.getClass();
        //获取类的名称
        System.out.println("类的名称：" + c1.getName());
        /**
         * Method类，方法对象
         * 一个成员方法就是一个Method对象
         * getMethods()方法获取的是所有的public的函数，包括父类继承而来的
         * getDeclaredMethods()获取的是所有该类自己声明的方法，不问访问权限
         */
        Method[] ms = c1.getMethods();//c.getDeclaredMethods();
        for (int i = 0; i < ms.length; i++) {
            //得到方法的返回值类型的类类型
            Class<?> returnType = ms[i].getReturnType();
            System.out.print(returnType.getName() + " ");
            //得到方法的名称
            System.out.print(ms[i].getName() + "(");
            //获取参数类型--->得到的是参数列表的类型的类类型
            Class<?>[] paramTypes = ms[i].getParameterTypes();
            for (Class<?> class1 : paramTypes) {
                System.out.print(class1.getName() + ",");
            }
            System.out.println(")");
        }
    }

    /**
     * 获取成员变量的信息
     *
     * @param obj
     */
    public static void printClassFieldMsg(Object obj) {
        Class<?> c1 = obj.getClass();
        /**
         * 成员变量也是对象
         * java.lang.reflect.Field
         * Field类封装了关于成员变量的操作
         * getFields()方法获取的是所有的public的成员变量的信息(包括继承的)
         * getDeclaredFields()获取的是该类自己声明的所有的成员变量的信息
         */
        //Field[] fs = c1.getFields();
        Field[] fs = c1.getDeclaredFields();
        for (Field field : fs) {
            //得到成员变量的类型的类类型
            Class<?> fieldType = field.getType();
            String typeName = fieldType.getName();
            //得到成员变量的名称
            String fieldName = field.getName();
            System.out.println(typeName + " " + fieldName);
        }
    }

    /**
     * 打印对象的构造函数的信息
     *
     * @param obj
     */
    public static void printClassConMsg(Object obj) {
        Class<?> c1 = obj.getClass();
        /**
         * 构造函数也是对象
         * java.lang.Constructor中封装了构造函数的信息
         * getConstructors()获取所有的public的构造函数
         * getDeclaredConstructors()得到所有的构造函数
         */
        Constructor<?>[] cs = c1.getDeclaredConstructors();
        for (Constructor<?> constructor : cs) {
            System.out.print(constructor.getName() + "(");
            //获取构造函数的参数列表--->得到的是参数列表的类类型
            Class<?>[] paramType = constructor.getParameterTypes();
            for (Class<?> class1 : paramType) {
                System.out.print(class1.getName() + ",");
            }
            System.out.println(")");
        }
    }
}