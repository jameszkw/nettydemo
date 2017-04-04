package com.zkw.netty.packet.resolve_fragassemly;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
public class TimeClientHandler extends SimpleChannelInboundHandler {
    private int counter;
    private byte[] req;

    public TimeClientHandler() {
        req=("query time order"+System.getProperty("line.separator")).getBytes();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        String body=(String)o;
        System.out.printf("now is: "+body+" ; the counter is: "+ ++counter);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf mes=null;
        for (int i=0;i<100;i++){
            mes= Unpooled.buffer(req.length);
            mes.writeBytes(req);
            ctx.writeAndFlush(mes);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
