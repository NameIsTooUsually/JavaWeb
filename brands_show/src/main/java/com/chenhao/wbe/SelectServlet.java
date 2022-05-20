package com.chenhao.wbe;

import com.alibaba.fastjson.JSON;
import com.chenhao.pojo.Brand;
import com.chenhao.service.BrandService;
import com.chenhao.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
    private BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用方法
        List<Brand> brands = brandService.selectAll();

        //转换成json字符串
        String s = JSON.toJSONString(brands);

        //设置编码
        response.setContentType("text/json;charset=utf-8");

        //响应数据
        response.getWriter().write(s);
    }
}
