package com.zkw.netty.bookdemo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
public class TimeClientHandler extends SimpleChannelInboundHandler {
    private final ByteBuf firstMes;

    public TimeClientHandler() {
        byte[] req="query time order".getBytes();
        firstMes= Unpooled.buffer(req.length);
        firstMes.writeBytes(req);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(firstMes);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        ByteBuf buf=(ByteBuf)o;
        byte[] req=new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body=new String (req,"utf-8");
        System.out.println("now is: "+body);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //释放资源
        System.out.println(cause.getMessage());
        ctx.close();
    }
}
