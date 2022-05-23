package com.heima.web.userServlet;

import com.alibaba.fastjson.JSON;
import com.heima.pojo.Result;
import com.heima.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/getUsername.do")
public class UserServlet extends HttpServlet {

    //获取用户名信息，用户登录成功后，在session中存储了user对象，从中获取即可
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        response.setContentType("text/json;charset=utf-8");
        //获取session对象
        HttpSession session = request.getSession();
        //获取用户对象
        User user = (User) session.getAttribute("user");

        //创建result对象  {"flag":true,"message":"获取当前登录用户名称成功","data":"admin"}
        Result result = new Result(true,"获取当前登录用户名称成功",user.getUsername());

        //响应
        response.getWriter().write(JSON.toJSONString(result));
    }
}
