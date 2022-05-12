package com.chenhao.servlet_demo.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/responseDemo1")
public class responseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("responseDemo1");
        response.setStatus(302);
        //动态获取虚拟路径目录
        String contextPath = request.getContextPath();

        response.setHeader("location",contextPath+"/responseDemo2");
        //response.setHeader("location","https://WWW.baidu.com");
    }
}
