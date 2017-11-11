package com.imooc.socket.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.socket.ch02
 * @description: 使用URL读取网页内容
 * @date 2017/11/11 16:13
 */
public class UrlDemo2 {

    public static void main(String[] args) throws IOException {
        String spec = "http://www.cuit.edu.cn/";
//		String spec = "http://www.baidu.com/";
        //创建一个URL对象
        URL url = new URL(spec);
        //通过URL的
        InputStream in = url.openStream();
        //将字节输入流转换为字符输入流
        InputStreamReader isr = new InputStreamReader(in, "UTF-8");
        //为字符输入流添加缓冲
        BufferedReader br = new BufferedReader(isr);
        String data = null;
        while ((data = br.readLine()) != null) {
            System.out.println(data);
        }
        br.close();
        isr.close();
        in.close();
    }
}
