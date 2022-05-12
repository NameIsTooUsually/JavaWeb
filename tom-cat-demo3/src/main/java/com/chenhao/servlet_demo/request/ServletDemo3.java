package com.chenhao.servlet_demo.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/*
中文乱码问题解决
 */
@WebServlet("/ServletDemo3")
public class ServletDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post的解决方式
        request.setCharacterEncoding("utf-8");
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取参数
        //设置流的编码方式


        String username = request.getParameter("username");

        username = URLDecoder.decode(new String(URLEncoder.encode(username, "ISO_8859_1").getBytes()), "UTF-8");
        System.out.println(username);
    }
}
