package com.algorithm.drill.day4.ch02;

/**
 * 输出结果：
 * ---------Into Inner-----------
 * 10
 * ---------End Inner-----------
 *
 * @author Luo
 */
public class Outer {

    public void doSomething() {
        final int a = 10;
        class Inner {
            public void seeOuter() {
                System.out.println(a);
            }
        }
        System.out.println("---------Into Inner-----------");
        Inner inner = new Inner();
        inner.seeOuter();
        System.out.println("---------End Inner-----------");
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.doSomething();
    }

}
