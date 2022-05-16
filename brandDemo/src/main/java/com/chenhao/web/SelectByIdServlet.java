package com.chenhao.web;

import com.chenhao.pojo.Brand;
import com.chenhao.service.imp.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SelectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    private BrandServiceImpl brandService = new BrandServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取id
        String id = request.getParameter("id");
        Brand brand = brandService.selectById(Integer.parseInt(id));
        request.setAttribute("brand",brand);
        //展示数据
       request.getRequestDispatcher("UpdateBrand.jsp").forward(request,response);
    }
}
