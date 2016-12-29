package com.mjc.socketService.clientTest;

import java.io.*;
import java.net.Socket;

/**
 * Created by justin-Mao on 16-12-29.
 */
public class SocketClient {
    public static void main(String[] args) {
        try {
            //创建socket对象
            Socket socket = new Socket("localhost",8888);

            //根据输入输出流和服务端连接
            OutputStream outputStream = socket.getOutputStream();//获取一个输出流,向服务端发送信息
            PrintWriter printWriter = new PrintWriter(outputStream);//将输出流包装成打印流
            printWriter.print("hello,service,I'm Justin");
            socket.shutdownOutput();

            InputStream inputStream = socket.getInputStream();//获取输入流,接受服务端的消息
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String info ="";
            String temp =null;

            while ((temp=bufferedReader.readLine())!=null){
                info+=temp;
                System.out.println("客户端接收服务端发送消息"+info);
            }

            bufferedReader.close();
            inputStream.close();
            printWriter.close();
            outputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
