package com.login;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ClientTestDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 10010);

        //获取输入对象
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名：");
        String username = bufferedReader.readLine();
        System.out.println("请输入密码：");
        String pwd = bufferedReader.readLine();

        //获取输出对象
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(username);
        out.println(pwd);

        //获取输入流对象
        BufferedReader serverR = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String result = serverR.readLine();
        System.out.println(result);
        socket.close();
    }
}
