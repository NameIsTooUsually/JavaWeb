package com.heima.web.checkItemServlet;

import com.alibaba.fastjson.JSON;
import com.heima.pojo.CheckItem;
import com.heima.pojo.Result;
import com.heima.service.CheckItemService;
import com.heima.service.UserService;
import com.heima.service.impl.CheckItemServiceImpl;
import com.heima.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkitem/findById.do")
public class FindByIdServlet extends HttpServlet {
    CheckItemService checkItemService = new CheckItemServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        response.setContentType("text/json;charset=utf-8");
        //获取参数
        String _id = request.getParameter("id");
        int id = Integer.parseInt(_id);
        //调用方法
        CheckItem checkItem = checkItemService.findById(id);


        //创建result对象
        Result result = new Result();
        if(null!=checkItem){
            result.setFlag(true);
            result.setData(JSON.toJSONString(checkItem));

        }else{
            result.setFlag(false);
            result.setMessage("查询错误");
        }
        //System.out.println(JSON.toJSONString(result));
        //响应数据
        response.getWriter().write(JSON.toJSONString(result));
    }
}
