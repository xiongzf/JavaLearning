package com.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTestDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10010);
        Socket socket = serverSocket.accept();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String username = bufferedReader.readLine();
        String pwd = bufferedReader.readLine();

        boolean flag = false;
        flag = StudentDB.getList().contains(new Student(username, pwd));

        //获取输出流对象
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        if (flag) {
            printWriter.println("登录成功");
        } else {
            printWriter.println("登录失败");
        }

        socket.close();
    }
}
