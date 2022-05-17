package com.chenhao.web;

import com.chenhao.Utils.CheckCodeUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //获取输出流
        ServletOutputStream os = response.getOutputStream();
        //生成验证码
        String s = CheckCodeUtil.outputVerifyImage(100, 50, os, 4);

        //将验证码存入session
        HttpSession session = request.getSession();
        session.setAttribute("checkCode",s);
    }
}
