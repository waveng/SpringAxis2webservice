package com.mjc.socketService.service;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by justin-Mao on 16-12-29.
 */
public class SocketThreadServer {

    public static void main(String[] args) {
        try {
            ServerSocket socketServer = new ServerSocket(8888);
            System.out.println("服务端已启动,等待连接");

            while(true){
                Socket socket = socketServer.accept();
                SocketThread socketThread = new SocketThread(socket);
                socketThread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
