package com.imooc.io.ch05;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.io.ch05
 * @description: TODO
 * @date 2017/11/11 15:52
 */
public class Student implements Serializable {
    private String stuNo;
    private String stuName;
    //该元素不会进行jvm默认的序列化,也可以自己完成这个元素的序列化
    private transient int stuAge;

    public Student() {
        super();
    }

    public Student(String stuNo, String stuName, int stuAge) {
        super();
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuAge = stuAge;
    }


    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    @Override
    public String toString() {
        return "Student [stuNo=" + stuNo + ", stuName=" + stuName + ", stuAge="
                + stuAge + "]";
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        //把jvm能默认序列化的元素进行序列化操作
        out.defaultWriteObject();
        //自己完成stuAge的序列化
        out.writeInt(stuAge);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        //把jvm能默认反序列化的元素进行反序列化操作
        in.defaultReadObject();
        //自己完成stuage的反序列化操作
        this.stuAge = in.readInt();
    }
}
