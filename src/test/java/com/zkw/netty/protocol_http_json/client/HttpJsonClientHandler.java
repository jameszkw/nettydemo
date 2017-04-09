package com.zkw.netty.protocol_http_json.client;

import com.zkw.netty.protocol_http_json.codec.HttpJsonRequest;
import com.zkw.netty.protocol_http_json.codec.HttpJsonResponse;
import com.zkw.netty.protocol_http_json.pojo.OrderFactory;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by Administrator on 2017/4/5 0005.
 */
public class HttpJsonClientHandler extends SimpleChannelInboundHandler<HttpJsonResponse> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpJsonResponse msg) throws Exception {
        System.out.println("The client receive response of http header is : "
                + msg.getHttpResponse().headers().names());
        System.out.println("The client receive response of http body is : "
                + msg.getResult());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive");
        HttpJsonRequest request = new HttpJsonRequest(null,OrderFactory.create(123));
        ctx.writeAndFlush(request);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
