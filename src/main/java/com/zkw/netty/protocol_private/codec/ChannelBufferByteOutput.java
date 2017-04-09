package com.zkw.netty.protocol_private.codec;

import io.netty.buffer.ByteBuf;
import org.jboss.marshalling.ByteOutput;

import java.io.IOException;

/**
 * ${DESCRIPTION}
 *
 * @author James
 * @create 2017-04-08 上午 10:36
 **/

public class ChannelBufferByteOutput implements ByteOutput {
    private final ByteBuf buffer;

    /**
     * Create a new instance which use the given {@link ByteBuf}
     */
    public ChannelBufferByteOutput(ByteBuf buffer) {
        this.buffer = buffer;
    }


    public void write(int i) throws IOException {
        buffer.writeByte(i);
    }

    public void write(byte[] bytes) throws IOException {
        buffer.writeBytes(bytes);
    }

    public void write(byte[] bytes, int srcIndex, int length) throws IOException {
        buffer.writeBytes(bytes, srcIndex, length);
    }

    /**
     * Return the {@link ByteBuf} which contains the written content
     *
     */
    ByteBuf getBuffer() {
        return buffer;
    }

    public void close() throws IOException {

    }

    public void flush() throws IOException {

    }
}
