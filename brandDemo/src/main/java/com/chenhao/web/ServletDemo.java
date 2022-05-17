package com.chenhao.web;

import com.chenhao.pojo.Brand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/ServletDemo")
public class ServletDemo extends BaseServlet {
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");

        //封装到对象
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(Integer.parseInt(ordered));
        brand.setDescription(description);
        brand.setStatus(Integer.parseInt(status));

        //调用方法
        brandService.add(brand);

        //添加后，将添加内容显示出来。使用重定向
        response.sendRedirect("/brandDemo/SelectServlet");

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");

        //调用函数进行删除
        brandService.deleteById(Integer.parseInt(id));

        //显示

        //添加后，将添加内容显示出来。使用重定向
        response.sendRedirect("/brandDemo/SelectServlet");
    }

    protected void selectByid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取id
        String id = request.getParameter("id");
        Brand brand = brandService.selectById(Integer.parseInt(id));
        request.setAttribute("brand",brand);
        //展示数据
        request.getRequestDispatcher("UpdateBrand.jsp").forward(request,response);
    }

    protected void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //执行brandService对象中查询所有方法
        List<Brand> brands = brandService.selectAll();
        //传入request域
        request.setAttribute("brands",brands);
        request.getRequestDispatcher("selectAll.jsp").forward(request,response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
