package com.heima.web.checkItemServlet;

import com.alibaba.fastjson.JSON;
import com.heima.pojo.CheckItem;
import com.heima.pojo.Result;
import com.heima.service.CheckItemService;
import com.heima.service.impl.CheckItemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/checkitem/findAll.do")
public class FindAllServlet extends HttpServlet {
    CheckItemService checkItemService = new CheckItemServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");

        //调用方法
        List<CheckItem> items = checkItemService.findAll();
        String s = JSON.toJSONString(items);

        //创建result对象
        Result result = new Result();
        result.setData(s);
        result.setFlag(true);
        result.setMessage("查询检查项成功");

        //转换成JSON字符串
        response.getWriter().write(JSON.toJSONString(result));

    }
}
