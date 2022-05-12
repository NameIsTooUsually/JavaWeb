package com.chenhao.servlet_demo.response;


import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/responseDemo4")
public class responseDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*//相应字节数据
        //1读取文件
        FileInputStream input = new FileInputStream("C:/picture/deecbda6880411ebb6edd017c2d2eca2.jpg");
        BufferedInputStream bis = new BufferedInputStream(input);
        //获取response输出流
        ServletOutputStream output = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(output);

        //写入数据
        byte[] bytes = new byte[1024];
        int len = 0;

        while ((len = bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        bis.close();*/

        //使用io拷贝工具

        FileInputStream input = new FileInputStream("C:/picture/deecbda6880411ebb6edd017c2d2eca2.jpg");
        ServletOutputStream output = response.getOutputStream();

        IOUtils.copy(input,output);
        input.close();
    }
}
