package com.imooc.io.ch02;

import java.io.File;
import java.io.IOException;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.io.ch02
 * @description: 文件操作工具类
 * @date 2017/11/11 15:39
 */
public class FileUtils {
    /**
     * 列出指定目录下（包括其子目录）的所有文件
     */
    public static void listDirectory(File dir) throws IOException {
        if (!dir.exists()) {
            throw new IllegalArgumentException("目录" + dir + "不存在.");
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + "不是目录.");
        }
//		String[] fileNames = dir.list();
//		for (String string : fileNames) {
//			System.out.println(dir + File.separator + string);
//		}

        //遍历子目录下的内容
        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory()) {
                    //如果是目录，做递归
                    listDirectory(file);
                } else {
                    System.out.println(file);
                }
            }
        }
    }
}
