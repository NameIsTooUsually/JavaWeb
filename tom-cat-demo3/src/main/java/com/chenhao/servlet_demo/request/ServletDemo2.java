package com.chenhao.servlet_demo.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/ServletDemo2")
public class ServletDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get请求逻辑
        //System.out.println("get....");
        //1获取所有参数的map集合
        Map<String, String[]> map = req.getParameterMap();
        //2获取集合内容
        for (String key : map.keySet()) {
            //打印key
            System.out.print(key + ':');

            //打印值
            String[] values = map.get(key);
            for (String value : values) {
                System.out.print(value + ' ');
            }

            System.out.println();
        }
        System.out.println("===================");
        //2获取对应的参数值
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
        System.out.println("===============");
        // 3 根据key获取单个参数值
        String password = req.getParameter("password");
        System.out.println(password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
