package com.imooc.socket.ch03;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.Socket;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.socket.ch03
 * @description: 客户端
 * @date 2017/11/11 16:21
 */
public class Client {

    public static void main(String[] args) throws IOException {
        //1. 创建客户端Socket，指定服务器地址和端口
        Socket socket = new Socket("localhost", 10086);
        //2. 获取输入流，向服务器端发送信息
        OutputStream out = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(out);
        pw.write("用户名：罗聪;密码：123456");
        pw.flush();
        socket.shutdownOutput();//关闭输出流
        //3. 获取输入流，读取服务器端返回的信息
        InputStream in = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(in, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String info = null;
        while ((info = br.readLine()) != null) {
            System.out.println("服务器端说：" + info);
        }
        socket.shutdownInput();//关闭输入流

        //4. 关闭资源
        //不需要关闭，对于同一个Socket,如果关闭了输出流,
        //则与该输出流关联的Socket也会被关闭,所以一般不用关闭流,直接关闭Socket即可
//		pw.close();
        IOUtils.closeQuietly(br, isr, in, out, socket);
    }
}
