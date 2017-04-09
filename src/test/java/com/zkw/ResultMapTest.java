package com.zkw;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * Created by Administrator on 2016/5/10 0010.
 */
public class ResultMapTest {
    @Test
    public void test(){
        String str="算";
        Charset charset=Charset.forName("utf-8");
        ByteBuffer byteBuffer=charset.encode(str);
        System.out.println(byteBuffer.toString());
        CharBuffer charBuffer=charset.decode(byteBuffer);
        System.out.println(charBuffer.toString());


    }


}
