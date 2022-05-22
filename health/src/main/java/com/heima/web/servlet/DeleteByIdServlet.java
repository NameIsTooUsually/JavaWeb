package com.heima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.heima.pojo.Result;
import com.heima.service.UserService;
import com.heima.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkitem/delete.do")
public class DeleteByIdServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        response.setContentType("text/json;charset=utf-8");
        //获取参数
        String id = request.getParameter("id");
        //调用方法
        userService.deleteById(Integer.parseInt(id));

        //创建result对象
        Result result = new Result();
        //设置参数
        result.setFlag(true);
        result.setMessage("删除检查项成功");

        //响应数据
        response.getWriter().write(JSON.toJSONString(result));
    }
}
