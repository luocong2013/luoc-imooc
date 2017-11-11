package com.imooc.socket.ch04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.socket.ch04
 * @description: 服务器端，实现基于UDP的用户登录
 * @date 2017/11/11 16:27
 */
public class UdpServer {

    public static void main(String[] args) throws IOException {
        //1. 创建服务器端DatagramSocket，指定端口
        DatagramSocket socket = new DatagramSocket(10086);
        //2. 创建数据报，用于接收客户端发送的数据
        byte[] data = new byte[4 * 1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);
        //3. 接收客户端发送的数据
        System.out.println("***服务器端已经启动，等待客服端连接***");
        socket.receive(packet);//此方法在接受到数据报之前会一直阻塞
        //4. 读数据
        String info = new String(data, 0, packet.getLength());
        System.out.println("我是服务器端，客户端发送的信息是：" + info);

        /**
         * 向客户端响应数据
         */
        //1. 定义客户端的地址、端口号、数据
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        byte[] data2 = "欢迎您~".getBytes();
        //2. 创建数据报，包含响应的数据信息
        DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
        //3. 响应客户端
        socket.send(packet2);
        //4. 关闭资源
        socket.close();
    }
}
