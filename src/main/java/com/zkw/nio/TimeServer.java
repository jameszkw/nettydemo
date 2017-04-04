package com.zkw.nio;

/**
 * NIO时间服务端
 */
public class TimeServer {
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
        MultiplexerTimeServer timeServer=new MultiplexerTimeServer(port);
        new Thread(timeServer,"nio-multiplexerTimeServer-001").start();
    }
}
