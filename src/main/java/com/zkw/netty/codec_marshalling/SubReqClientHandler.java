package com.zkw.netty.codec_marshalling;

import com.zkw.netty.codec_marshalling.pojo.SubscribeReq;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * ${DESCRIPTION}
 *
 * @author James
 * @create 2017-04-08 下午 8:43
 **/

public class SubReqClientHandler extends SimpleChannelInboundHandler {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            ctx.write(subReq(i));
        }
        ctx.flush();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Receive server response : [" + msg + "]");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    private SubscribeReq subReq(int i) {
        SubscribeReq req = new SubscribeReq();
        req.setAddress("NanJing YuHuaTai");
        req.setPhoneNumber("138xxxxxxxxx");
        req.setProductName("Netty Book For Marshalling");
        req.setSubReqID(i);
        req.setUserName("Lilinfeng");
        return req;
    }
}
