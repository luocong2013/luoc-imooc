package com.imooc.socket.ch03;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.socket.ch03
 * @description: 服务器端 基于TCP协议的Socket通信，实现用户登录
 * @date 2017/11/11 16:23
 */
public class Server {

    public static void main(String[] args) throws IOException {
        //创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
        ServerSocket serverSocket = new ServerSocket(10086);
        Socket socket = null;
        //记录客户端连接数量
        int count = 0;
        System.out.println("***服务器已启动，等待客户端的连接***");
        //循环监听等待客户端的连接
        while (true) {
            //调用accept()方法开始监听，等待客户端的连接
            socket = serverSocket.accept();
            //创建一个新的线程
            ServerThread serverThread = new ServerThread(socket);
            //多线程的优先级（死循环中注意设置优先级问题。）建议降低优先级
            serverThread.setPriority(4);//设置线程优先级
            //启动线程
            serverThread.start();
            count++;
            System.out.println("客户端连接数量是：" + count);
            InetAddress address = socket.getInetAddress();
            System.out.println("当前客户端的IP地址是：" + address.getHostAddress());
        }
    }
}
