package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/showAddPage")
public class ShowAddPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //生成一个id
        String checkId = UUID.randomUUID().toString();
        //获取session对象
        HttpSession session = request.getSession();
        session.setAttribute("checkId",checkId);

        //存储到request域中
        request.setAttribute("checkId1",checkId);

        //跳转到 add.jsp 页面
        request.getRequestDispatcher("/WEB-INF/pages/add.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
