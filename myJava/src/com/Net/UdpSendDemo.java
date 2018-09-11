package com.Net;

import java.io.IOException;
import java.net.*;

public class UdpSendDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();

        String s = "hello,world,udp";
        byte[] bys = s.getBytes();
        int length = bys.length;

        InetAddress address = InetAddress.getLocalHost();
        int port = 8888;

        DatagramPacket dp = new DatagramPacket(bys, length, address, port);
        ds.send(dp);
        ds.close();
    }
}
