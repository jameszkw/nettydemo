package com.zkw.netty.protocol_http_json.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;

import java.util.List;

/**
 * Created by Administrator on 2017/4/5 0005.
 */
public class HttpJsonResponseDecoder extends
        AbstractHttpJsonDecoder<DefaultFullHttpResponse> {
    public HttpJsonResponseDecoder(Class<?> clazz) {
        super(clazz);
    }

    public HttpJsonResponseDecoder(Class<?> clazz, boolean isPrint) {
        super(clazz, isPrint);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, DefaultFullHttpResponse msg, List<Object> out) throws Exception {
        HttpJsonResponse resHttpXmlResponse = new HttpJsonResponse(msg, decode0(
                ctx, msg.content()));
        out.add(resHttpXmlResponse);
    }
}
