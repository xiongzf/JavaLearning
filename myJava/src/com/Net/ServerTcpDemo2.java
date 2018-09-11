package com.Net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTcpDemo2 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10010);
        Socket socket = ss.accept();

        //接收数据
        InputStream is = socket.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        String str = new String(bys, 0, len);

        System.out.println(str);

        //发送数据
        OutputStream os = socket.getOutputStream();
        os.write(str.toUpperCase().getBytes());

        socket.close();

//        ss.close(); //一般情况下不关闭服务端
    }
}
