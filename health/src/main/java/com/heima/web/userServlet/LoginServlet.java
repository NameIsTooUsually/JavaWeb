package com.heima.web.userServlet;

import com.heima.pojo.User;
import com.heima.service.UserService;
import com.heima.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 设置编码
        request.setCharacterEncoding("utf-8");
        //2. 获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //3.调用方法
        User user = userService.login(username, password);
        //判断
        if(null==user){
            //此时说明登录不成功，重新跳转到登录页面
            response.sendRedirect("http://localhost:8080/login.html");
            return;
        }
        //获取session设置登录状态
        request.getSession().setAttribute("user",user);
        //跳转到登录成功页面
        response.sendRedirect("http://localhost:8080/pages/main.html");
    }
}
