package com.zkw.netty.protocol_http_json.codec;

import com.google.gson.Gson;
import com.zkw.util.common.JsonUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.io.StringWriter;
import java.nio.charset.Charset;

/**
 * Created by Administrator on 2017/4/5 0005.
 */
public abstract class AbstractHttpJsonEncoder<T> extends MessageToMessageEncoder<T> {
    final static String CHARSET_NAME = "UTF-8";
    final static Charset UTF_8 = Charset.forName(CHARSET_NAME);

    protected ByteBuf encode0(ChannelHandlerContext ctx, Object body)
            throws Exception {
        String json =new Gson().toJson(body);
        ByteBuf encodeBuf = Unpooled.copiedBuffer(json, UTF_8);
        return encodeBuf;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
