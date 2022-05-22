package com.heima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.heima.pojo.Page;
import com.heima.pojo.PageBeanResult;
import com.heima.service.UserService;
import com.heima.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkitem/findPage.do")
public class CheckItemServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();


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
        Page pageJson = JSON.parseObject(request.getReader().readLine(), Page.class);
        int currentPage = pageJson.getCurrentPage();
        int pageSize = pageJson.getPageSize();

        //调用方法
        PageBeanResult pageBeanResult = userService.selectByPage(currentPage, pageSize);
        pageBeanResult.setFlag(true);
        pageBeanResult.setMessage("成功");

        //转换成json
        String checkItemJsonStr = JSON.toJSONString(pageBeanResult);

        //响应数据
        response.getWriter().write(checkItemJsonStr);

    }
}
