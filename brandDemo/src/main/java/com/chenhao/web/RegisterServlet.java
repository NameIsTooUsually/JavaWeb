package com.chenhao.web;

import com.chenhao.pojo.User;
import com.chenhao.service.imp.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取验证码用户输入的验证码
        String checkCode = request.getParameter("checkCode");
        //获取session中的验证码
        HttpSession session = request.getSession();
        String checkCode1 = (String) session.getAttribute("checkCode");

        if(!checkCode1.equalsIgnoreCase(checkCode)){
            //注册失败
            request.setAttribute("errorMsg","验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }


        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //封装对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        //调用方法进行注册
        boolean register = userService.register(user);
        if(register){
            //此时注册成功，跳转到登录界面
            //输出注册成功
            request.setAttribute("errorMsg","注册成功请登录");
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }else{
            //注册失败
            request.setAttribute("errorMsg","用户名已经存在");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }
}
