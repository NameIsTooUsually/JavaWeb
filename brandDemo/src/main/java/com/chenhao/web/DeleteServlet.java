package com.chenhao.web;

import com.chenhao.service.imp.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

    private BrandServiceImpl brandService = new BrandServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");

        //调用函数进行删除
        brandService.deleteById(Integer.parseInt(id));

        //显示

        //添加后，将添加内容显示出来。使用重定向
        response.sendRedirect("/brandDemo/SelectServlet");
    }
}
