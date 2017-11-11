package com.imooc.io.ch02;

import java.io.File;
import java.io.IOException;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.io.ch02
 * @description: TODO
 * @date 2017/11/11 15:46
 */
public class FileUtilsTest {
    public static void main(String[] args) throws IOException {
        File file = new File("F:\\Java\\My App\\MyStruts221");
        FileUtils.listDirectory(file);
    }
}
