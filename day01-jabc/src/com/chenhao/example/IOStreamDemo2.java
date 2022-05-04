package com.chenhao.example;

import java.io.*;

public class IOStreamDemo2 {
    public static void main(String[] args) throws IOException {
        //创建一个字符输出转换流
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("test2.txt"),"UTF-8");
        osw.write("学习使我快乐");
        //刷新流。关流
        osw.flush();
        osw.close();
        //创建一个转换输入流
        InputStreamReader isr = new InputStreamReader(new FileInputStream("test2.txt"),"utf-8");
        //读取字符
        int b;
        while ((b=isr.read())!=-1){
            System.out.print((char)b);
        }
        //关流
        isr.close();
    }
}
