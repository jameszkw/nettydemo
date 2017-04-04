package com.zkw.nio;

/**
 * NIO时间服务客户端
 */
public class TimeClient {
    public static void main(String[] args) {
        int port=8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("args[0] 不是数据类型");
                port = 8080;
            }
        }
        new Thread(new TimeClientHandle("127.0.0.1",port),"nio-TimeClient-001").start();
    }
}
