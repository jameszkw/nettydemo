package com.zkw.fakenio;

import com.zkw.bio.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 伪异步I/O 服务端 通过线程池来优化线程资源耗尽
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("args[0] 不是数据类型");
                port = 8080;
            }
        }
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port: "+port);
            Socket socket = null;
            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(50,10000);
            while (true){
                socket=server.accept();
                singleExecutor.execute(new com.zkw.fakenio.TimeServerHandler(socket));
            }
        } catch (IOException e) {
            System.out.println("ServerSocket 创建失败："+e);
        }finally {
            if(server!=null){
                System.out.println("The time server close");
                try {
                    server.close();
                } catch (IOException e) {
                    System.out.println("ServerSocket 关闭失败："+e);
                }
            }
        }

    }
}
