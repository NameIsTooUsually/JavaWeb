package com.chenhao.web;

import com.chenhao.pojo.Brand;
import com.chenhao.service.imp.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BandCombineOp;
import java.io.IOException;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private BrandServiceImpl brandService = new BrandServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //获取参数
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        String id = request.getParameter("id");

        //封装到对象
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(Integer.parseInt(ordered));
        brand.setDescription(description);
        brand.setStatus(Integer.parseInt(status));
        brand.setId(Integer.parseInt(id));

        brandService.update(brand);

        //修改后，将添加内容显示出来。使用重定向
        response.sendRedirect("/brandDemo/SelectServlet");

    }
}
