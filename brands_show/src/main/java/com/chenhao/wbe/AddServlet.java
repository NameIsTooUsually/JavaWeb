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

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {

    private BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");

        //获取数据
        String jsonStr = request.getReader().readLine();

        //将数据转换成对象
        Brand brand = JSON.parseObject(jsonStr, Brand.class);

        //调用方法
        brandService.addBrand(brand);

        //设置编码并响应
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write("success");


    }
}
