package com.itheima.servlet;

import com.itheima.pojo.Goods;
import com.itheima.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addGoods")
public class AddGoodsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1，解决post请求乱码问题
        request.setCharacterEncoding("utf-8");
        //2，获取请求参数
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String description = request.getParameter("description");


        //检查checkID
        //获取用户提交的checkId
        String checkId1 = request.getParameter("checkId1");
        //获取session中的checkId
        HttpSession session = request.getSession();
        String checkId = (String) session.getAttribute("checkId");


        if(!checkId1.equals(checkId)){
            //此时表单提交的checkid和Session中存储的不同，说明是重复提交
            //跳转到展示页面
            //6，跳转到查询所有的servlet
            response.sendRedirect("/findAllGoods");
            return;
        }

        //销毁session
        session.invalidate();


        //3，封装数据
        Goods goods = new Goods();
        goods.setName(name);
        goods.setPrice(Double.parseDouble(price));
        goods.setDescription(description);
        //4，创建GoodsService对象
        GoodsService goodsService = new GoodsService();
        //5，调用add方法添加数据
        goodsService.add(goods);
        //6，跳转到查询所有的servlet
        response.sendRedirect("/findAllGoods");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
