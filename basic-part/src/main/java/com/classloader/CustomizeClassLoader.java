package com.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author luoc
 * @version V1.0.0
 * @description 自定义ClassLoader
 * @date 2018/11/28 21:09
 */
public class CustomizeClassLoader extends ClassLoader {

    /**
     * 类加载器名称
     */
    private String name;
    /**
     * 加载类的路径
     */
    private String path;

    public CustomizeClassLoader(String name, String path) {
        // 让系统类加载器成为该类的父加载器
        super();
        this.name = name;
        this.path = path;
    }

    public CustomizeClassLoader(ClassLoader parent, String name, String path) {
        // 显示指定父加载器
        super(parent);
        this.name = name;
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) {
        byte[] data = readClassFileToByteArray(name);
        return this.defineClass(name, data, 0, data.length);
    }

    /**
     * 获取.class文件的字节数组
     *
     * @param name
     * @return
     */
    private byte[] readClassFileToByteArray(String name) {
        byte[] returnData = null;
        InputStream stream = null;
        name = name.replaceAll("\\.", "/");
        String filePath = this.path + name + ".class";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            stream = new FileInputStream(filePath);
            byte[] buf = new byte[8 * 1024];
            int length;
            while ((length = stream.read(buf, 0, buf.length)) != -1) {
                baos.write(buf, 0, length);
                baos.flush();
            }
            returnData = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
                if (baos != null) {
                    baos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return returnData;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
