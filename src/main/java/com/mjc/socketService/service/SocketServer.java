package com.mjc.socketService.service;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by justin-Mao on 16-12-29.
 */
public class SocketServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务端启已启动,等待客户端连接");

            Socket socket = serverSocket.accept();//监听并接受到此套接字的连接,返回一个Socket对象

            //根据输入输出流和客户端连接
            InputStream inputStream = socket.getInputStream();//得到一个输入流,接收客户端传递的消息
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);//将字节流转为字符流,提高效率
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);//加入缓冲区
            String temp = null;
            String info = null;
            while((temp = bufferedReader.readLine())!=null){
                info+=temp;
                System.out.println("已接收到客户端连接");
                System.out.println("服务端接受到客户端的信息: "+info+" 当前客户端IP为: "+socket.getInetAddress().getHostAddress());
            }

            OutputStream outputStream = socket.getOutputStream();//获取一个输出流,向服务端发送请求
            PrintWriter printWriter = new PrintWriter(outputStream);//将输出流包装成打印流
            printWriter.print("服务端收到信息");
            printWriter.flush();
            socket.shutdownOutput();

            printWriter.close();
            outputStream.close();
            bufferedReader.close();
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
