package com.chenhao.example;

import java.io.*;
import java.util.Arrays;

/*
需求
使用字符缓冲流读取文件中的数据，排序后再次写到本地文件
 */
public class IOStreamDemo {
    public static void main(String[] args) throws IOException {
        //创建字符缓冲输入流
        BufferedReader br = new BufferedReader(new FileReader("C:\\Develop\\project\\javaWeb\\day01-jabc\\src\\test.txt"));
        //读取文件中内容
        String s = br.readLine();
        //将字符串按照空格切割
        String[] s1 = s.split(" ");
        //关流
        br.close();

        //创建一个整数数组，将字符数组中字符转换并存入
        int[] arr = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            int temp = Integer.parseInt(s1[i]);
            arr[i] = temp;
        }
        //将整数数组排序
        Arrays.sort(arr);
        //缓冲字符输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Develop\\project\\javaWeb\\day01-jabc\\src\\test.txt",true));
        //写入文件
        bw.newLine();
        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i]+" ");
        }
        bw.flush();
        //关流
        bw.close();

    }
}
