package com.chenhao.wbe;


import com.alibaba.fastjson.JSON;
import com.chenhao.pojo.Brand;
import com.chenhao.pojo.PageBean;
import com.chenhao.service.BrandService;
import com.chenhao.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    private BrandService brandService = new BrandServiceImpl();


    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
    protected void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用方法
        List<Brand> brands = brandService.selectAll();

        //转换成json字符串
        String s = JSON.toJSONString(brands);

        //设置编码
        response.setContentType("text/json;charset=utf-8");

        //响应数据
        response.getWriter().write(s);
    }

    protected void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");

        //获取数据
        String jsonStr = request.getReader().readLine();

        //将数据转换成对象
        int[] ids = JSON.parseObject(jsonStr,int[].class);

        //调用方法
        brandService.deleteByIds(ids);

        //设置编码并响应
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write("success");
    }

    //分页查询
    protected void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //调用方法
        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);

        //转换成json字符串
        String s = JSON.toJSONString(pageBean);

        //设置编码
        response.setContentType("text/json;charset=utf-8");

        //响应数据
        response.getWriter().write(s);
    }

    //根据条件进行分页查询
    protected void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        //brand参数通过getParameter获取
        String brandStr = request.getReader().readLine();

        Brand brand = JSON.parseObject(brandStr, Brand.class);
        //调用方法
        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage, pageSize,brand);

        //转换成json字符串
        String s = JSON.toJSONString(pageBean);

        //设置编码
        response.setContentType("text/json;charset=utf-8");

        //响应数据
        response.getWriter().write(s);
    }

}
