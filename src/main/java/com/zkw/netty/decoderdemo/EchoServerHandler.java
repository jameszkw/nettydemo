package com.zkw.netty.decoderdemo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
public class EchoServerHandler extends SimpleChannelInboundHandler {
    int counter;
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        String body=(String)o;
        System.out.println("this is "+ ++counter+" time receive client :["+body+"]");
        body+="$_";
        ByteBuf echo= Unpooled.copiedBuffer(body.getBytes());
        channelHandlerContext.writeAndFlush(echo);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

}
