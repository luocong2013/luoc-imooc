package com.algorithm.drill.day6;

import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * Java获取本地机器MAC地址
 *
 * @author Luo
 */
public class MacAddress {

    public static String hexByte(byte b) {
        String s = "000000" + Integer.toHexString(b);
        return s.substring(s.length() - 2);
    }

    public static String getMAC() {
        Enumeration<NetworkInterface> el;
        String mac_s = "";
        try {
            el = NetworkInterface.getNetworkInterfaces();
            while (el.hasMoreElements()) {
                byte[] mac = el.nextElement().getHardwareAddress();
                if (mac == null || mac.length == 0) {
                    continue;
                }
                mac_s = hexByte(mac[0]) + "-" + hexByte(mac[1]) + "-"
                        + hexByte(mac[2]) + "-" + hexByte(mac[3]) + "-"
                        + hexByte(mac[4]) + "-" + hexByte(mac[5]);
                System.out.println("MAC地址：" + mac_s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mac_s;
    }

    public static void main(String[] args) {
        MacAddress.getMAC();
    }

}
