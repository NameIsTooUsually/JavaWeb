package com.heima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.heima.pojo.CheckItem;
import com.heima.pojo.Result;
import com.heima.service.UserService;
import com.heima.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkitem/add.do")
public class InsertByOBJServlet extends HttpServlet {
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
        String _checkItem = request.getReader().readLine();
        //转换成checkItem对象
        CheckItem checkItem = JSON.parseObject(_checkItem, CheckItem.class);

        //调用方法
        userService.insertByOBJ(checkItem);

        //创建result对象
        Result result = new Result();
        result.setFlag(true);
        result.setMessage("新增检查成功");

        //响应
        response.getWriter().write(JSON.toJSONString(result));

    }
}
