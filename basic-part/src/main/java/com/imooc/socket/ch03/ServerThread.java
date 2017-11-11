package com.imooc.socket.ch03;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.Socket;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.socket.ch03
 * @description: 服务器线程处理类
 * @date 2017/11/11 16:17
 */
public class ServerThread extends Thread {
    /**
     * 和本线程相关的Socket
     */
    private Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream in = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream out = null;
        PrintWriter pw = null;
        try {
            //获取输入流，并读取客户端信息
            in = socket.getInputStream();
            isr = new InputStreamReader(in, "UTF-8");
            br = new BufferedReader(isr);
            String info = null;
            while ((info = br.readLine()) != null) {//循环读取客户端信息
                System.out.println("我是服务器端，客户端发送的信息是：" + info);
            }
            socket.shutdownInput();//关闭输入流
            //获取输出流，向客户端返回信息
            out = socket.getOutputStream();
            pw = new PrintWriter(out);
            pw.write("欢迎光临~");
            pw.flush();
            socket.shutdownOutput();//关闭输出流
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5. 关闭资源
            //不需要关闭，对于同一个Socket,如果关闭了输出流,
            //则与该输出流关联的Socket也会被关闭,所以一般不用关闭流,直接关闭Socket即可
//			if (pw != null)
//				pw.close();
            IOUtils.closeQuietly(out, br, isr, in, socket);
        }
    }
}
