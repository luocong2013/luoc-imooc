package com.imooc.socket.ch02;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.socket.ch02
 * @description: TODO
 * @date 2017/11/11 16:14
 */
public class InetAddressDemo {

    public static void main(String[] args) throws UnknownHostException {
        //获取本机的InetAddress实例
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("计算机名：" + address.getHostName());
        System.out.println("IP地址：" + address.getHostAddress());
        System.out.println(address);
        byte[] b = address.getAddress();
        System.out.println("字节数组形式的IP：" + Arrays.toString(b));

//		InetAddress address2 = InetAddress.getByName("Luo-PC");
        InetAddress address2 = InetAddress.getByName("169.254.85.132");
        System.out.println("计算机名：" + address2.getHostName());
        System.out.println("IP地址：" + address2.getHostAddress());
    }
}
