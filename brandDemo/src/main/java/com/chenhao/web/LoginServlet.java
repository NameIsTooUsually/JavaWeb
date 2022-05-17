package com.chenhao.web;

import com.chenhao.pojo.User;
import com.chenhao.service.imp.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");

        //获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //判断是否勾选了记住
        String remember = request.getParameter("remember");
        if("1".equals(remember)){
            //勾选了记住框，需要将用户名密码存入cookie
            //将用户名进行转码
            String e_username = URLEncoder.encode(username, "utf-8");
            Cookie c_username = new Cookie("username",e_username);
            Cookie c_password = new Cookie("password",password);

            //设置cookKie保存时间
            c_password.setMaxAge(60*60*24*7);
            c_username.setMaxAge(60*60*24*7);

            //添加cookie
            response.addCookie(c_password);
            response.addCookie(c_username);
        }


        //调用方法
        User user = userService.login(username, password);

        //进行判断
        if(user!=null){
            //说明该用户存在。进行登录操作，跳转到展示所有商品信息页面
            HttpSession session = request.getSession();
            //将用户信息添加到session
            session.setAttribute("user",user);

            request.getRequestDispatcher("/SelectServlet").forward(request,response);

        }else{
            //如果返回结果为空，说明用户名不存在，登录失败给出提示

            request.setAttribute("errorMsg","用户名或密码错误");

            //转发到登录页面
            request.getRequestDispatcher("login.jsp").forward(request,response);

        }
    }
}
