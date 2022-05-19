package com.chenhao.web;

import com.alibaba.fastjson.JSON;
import com.chenhao.pojo.Brand;
import com.chenhao.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {

    private BrandServiceImpl brandService = new BrandServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");

        //获取参数
        BufferedReader reader = request.getReader();
        //获取json参数
        String s = reader.readLine();
        //将参数转换成对象
        Brand brand = JSON.parseObject(s, Brand.class);

        //调用方法
        brandService.add(brand);

        //响应数据
        response.getWriter().write("success");

    }
}
