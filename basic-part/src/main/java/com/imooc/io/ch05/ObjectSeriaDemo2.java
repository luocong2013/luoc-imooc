package com.imooc.io.ch05;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.io.ch05
 * @description: TODO
 * @date 2017/11/11 15:55
 */
public class ObjectSeriaDemo2 {
    public static void main(String[] args) throws Exception {
        String file = "G:/demo/obj1.dat";
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
//		Foo2 foo2 = new Foo2();
//		oos.writeObject(foo2);
//		oos.flush();
//		oos.close();

        //反序列化是否递归调用父类的构造函数
//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
//		Foo2 foo2 = (Foo2) ois.readObject();
//		System.out.println(foo2);
//		ois.close();

//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
//		Bar2 bar2 = new Bar2();
//		oos.writeObject(bar2);
//		oos.flush();
//		oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Bar2 bar2 = (Bar2) ois.readObject();
        System.out.println(bar2);
        ois.close();
        /**
         * 结果：
         * bar……
         * bar1……
         * com.imooc.five.ch05.Bar2@5c07612a
         */

        /**
         * 总结：
         * 对子类对象进行反序列化操作时，
         * 如果其父类没有实现序列化接口
         * 那么其父类的构造函数会被调用
         */
    }
}

/**
 * 一个类实现了序列化接口，那么其子类都可以进行序列化
 */
@SuppressWarnings("serial")
class Foo implements Serializable {
    public Foo() {
        System.out.println("foo……");
    }
}

@SuppressWarnings("serial")
class Foo1 extends Foo {
    public Foo1() {
        System.out.println("foo1……");
    }
}

@SuppressWarnings("serial")
class Foo2 extends Foo1 {
    public Foo2() {
        System.out.println("foo2……");
    }
}

class Bar {
    public Bar() {
        System.out.println("bar……");
    }
}

class Bar1 extends Bar {
    public Bar1() {
        System.out.println("bar1……");
    }
}

@SuppressWarnings("serial")
class Bar2 extends Bar1 implements Serializable {
    public Bar2() {
        System.out.println("bar2……");
    }
}