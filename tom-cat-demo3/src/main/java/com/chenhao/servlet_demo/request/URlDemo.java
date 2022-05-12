package com.chenhao.servlet_demo.request;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class URlDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //验证编码问题

        String name = "张三";
        //
        String encode = URLEncoder.encode(name, "utf-8");
        System.out.println(encode);

        String decode = URLDecoder.decode(encode, "ISO_8859_1");
        System.out.println(decode);

        byte[] bytes = decode.getBytes("ISO_8859_1");
        String s = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(s);

    }
}
