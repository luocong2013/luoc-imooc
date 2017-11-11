package com.imooc.io.ch02;

import java.io.File;
import java.io.FileFilter;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.io.ch02
 * @description: TODO
 * @date 2017/11/11 15:42
 */
public class FileDemo2 {

    public static void main(String[] args) {
        File file = new File("C:/Program Files (x86)");
        File[] files = file.listFiles(new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                return !"360".equals(pathname.getName());
            }
        });
        if (files != null && files.length > 0) {
            for (File f : files) {
                System.out.println(f);
            }
        }
    }
}
