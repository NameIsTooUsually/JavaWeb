package com.chenhao.web;

import com.chenhao.pojo.Brand;
import com.chenhao.service.imp.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
    private BrandServiceImpl brandService = new BrandServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //执行brandService对象中查询所有方法
        List<Brand> brands = brandService.selectAll();
        //传入request域
        request.setAttribute("brands",brands);
        request.getRequestDispatcher("selectAll.jsp").forward(request,response);
    }
}
