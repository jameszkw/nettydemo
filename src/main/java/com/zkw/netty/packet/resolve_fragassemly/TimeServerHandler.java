package com.zkw.netty.packet.resolve_fragassemly;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
public class TimeServerHandler extends SimpleChannelInboundHandler {
    private int counter;
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        String body=(String)o;
        System.out.println("the time server recieve order: "+body+" ; the counter is: "+ ++counter);
        String currentTime="query time order".equalsIgnoreCase(body)?new Date(System.currentTimeMillis()).toString():"bad order";
        currentTime=currentTime+System.getProperty("line.separator");
        ByteBuf resp= Unpooled.copiedBuffer(currentTime.getBytes());
        channelHandlerContext.writeAndFlush(resp);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
