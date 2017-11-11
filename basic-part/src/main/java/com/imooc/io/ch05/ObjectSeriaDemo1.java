package com.imooc.io.ch05;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.io.ch05
 * @description: TODO
 * @date 2017/11/11 15:54
 */
public class ObjectSeriaDemo1 {

    public static void main(String[] args) throws Exception {
        String file = "G:/demo/obj.dat";
        //1. 对象的序列化
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
//		Student stu = new Student("10001", "张三", 21);
//		oos.writeObject(stu);
//		oos.flush();
//		oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Student stu = (Student) ois.readObject();
        System.out.println(stu);
        ois.close();
    }
}
