package com.Net;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTcpDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10086);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);

        InetAddress address = socket.getInetAddress();
        System.out.println("client------>" + address.getHostAddress());
        System.out.println(new String(bys, 0, len));
        socket.close();
    }
}
