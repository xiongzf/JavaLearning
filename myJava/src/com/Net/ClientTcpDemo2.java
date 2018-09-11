package com.Net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientTcpDemo2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 10010);
        String s = "i'm coming, tcp";
        //发送数据
        OutputStream os = socket.getOutputStream();
        os.write(s.getBytes());

        //接受数据
        InputStream is = socket.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        System.out.println(new String(bys, 0, len));

        socket.close();
    }
}
