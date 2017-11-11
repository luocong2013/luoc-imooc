package com.imooc.socket.ch04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.socket.ch04
 * @description: 客户端
 * @date 2017/11/11 16:27
 */
public class UdpClient {
    public static void main(String[] args) throws IOException {
        //1. 定义服务器端的地址、端口号、数据
        InetAddress address = InetAddress.getByName("localhost");
        int port = 10086;
        byte[] data = "用户名：admin; 密码：123456".getBytes();
        //2. 创建数据报，包含要发送的数据信息
        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
        //3. 创建DatagramSocket对象
        DatagramSocket socket = new DatagramSocket();
        //4. 向服务器端发送数据报
        socket.send(packet);

        /**
         * 接收服务器端响应的数据
         */
        //1. 创建数据报，用于接收服务器端响应的数据
        byte[] data2 = new byte[4 * 1024];
        DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
        //2. 接收服务器响应的数据
        socket.receive(packet2);
        //3. 读取数据
        String reply = new String(data2, 0, packet2.getLength());
        System.out.println("服务器端响应的数据是：" + reply);
        //4. 关闭资源
        socket.close();
    }
}
