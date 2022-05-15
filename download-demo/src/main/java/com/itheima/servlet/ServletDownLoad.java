package com.itheima.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/download")
public class ServletDownLoad extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取请求的文件名称
        String filename = request.getParameter("filename");
        System.out.println(filename);
        //获取输入流读取文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("F:\\" + filename));
        //设置响应头内容

        response.setHeader("content-Disposition","attachment;filename="+filename);

        //获取输出流
        BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
        //流拷贝
        IOUtils.copy(bis,bos);

        //释放资源
        bis.close();
    }
}
