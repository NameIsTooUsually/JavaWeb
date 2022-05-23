package com.heima.web.checkItemServlet;

import com.alibaba.fastjson.JSON;
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

@WebServlet("/checkitem/delete.do")
public class DeleteByIdServlet extends HttpServlet {
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
        String id = request.getParameter("id");
        //调用方法
        boolean _result = checkItemService.deleteById(Integer.parseInt(id));

        //创建result对象
        Result result = new Result();
        if(_result){
            //删除成功
            //设置参数
            result.setFlag(true);
            result.setMessage("删除检查项成功");
        }else{
            //删除失败
            //设置参数
            result.setFlag(true);
            result.setMessage("删除检查项失败");
        }

        //响应数据
        response.getWriter().write(JSON.toJSONString(result));
    }
}
