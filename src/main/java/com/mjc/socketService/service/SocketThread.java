package com.mjc.socketService.service;

import jdk.nashorn.internal.ir.WhileNode;

import java.io.*;
import java.net.Socket;

/**
 * Created by justin-Mao on 16-12-29.
 */
public class SocketThread extends Thread {
    private Socket socket;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    public void run(){
        try {
            //得到一个输入流,接收客户端请求
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String temp = null;
            String info ="";

            while ((temp = bufferedReader.readLine())!=null){
                info +=temp;
                System.out.println("已接受到客户端连接");
                System.out.println("服务端接收到客户端信息: "+info+" 客户端IP: "+socket.getInetAddress().getHostAddress());
            }

            OutputStream outputStream = socket.getOutputStream();//获取一个输出流,向服务端发送请求
            PrintWriter printWriter = new PrintWriter(outputStream);//将输出流包装成打印流
            printWriter.print(" thread服务端收到信息");
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
