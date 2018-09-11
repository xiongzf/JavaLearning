package com.Net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientTcpDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 10086);
        OutputStream os = socket.getOutputStream();

        String str = "hello tcp ,ni da ye de tui er";
        os.write(str.getBytes());

        os.close();
        socket.close();
    }

}
