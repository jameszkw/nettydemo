package com.zkw.netty.packet.frag_assembly;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;

/**
 * 模拟出现tcp粘包拆包问题
 */
public class TimeServerHandler extends SimpleChannelInboundHandler {
    private int counter;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        ByteBuf buf=(ByteBuf)o;
//        byte[] req=new byte[]
    }
}
