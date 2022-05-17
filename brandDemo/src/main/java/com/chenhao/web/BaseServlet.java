package com.chenhao.web;

import com.chenhao.service.imp.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
    BrandServiceImpl brandService = new BrandServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //获取参数
        String methodName = request.getParameter("method");

        //获取字节码对象
        Class<? extends BaseServlet> servlet = this.getClass();

        //获取方法
        try {
            //获取方法
            Method method = servlet.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //暴力反射
            method.setAccessible(true);
            //执行程序
            Object object = method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
