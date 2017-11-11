package com.imooc.io.ch02;

import java.io.File;
import java.io.IOException;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.io.ch02
 * @description: TODO
 * @date 2017/11/11 15:40
 */
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("D:/luo");
        if (!file.exists()) {
            file.mkdir();
        } else {
            file.delete();
        }
        //是否是一个目录  如果是目录返回true,如果不是目录or目录不存在返回的是false
        System.out.println(file.isDirectory());
        //是否是一个文件
        System.out.println(file.isFile());
        File file2 = new File("D:\\luo", "日记1.txt");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            file2.delete();
        }
        System.out.println(file);//file.toString()的内容
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
        System.out.println(file2.getName());
        System.out.println(file.getParent());
        System.out.println(file2.getParent());
        System.out.println(file.getParentFile().getAbsolutePath());
    }

}
