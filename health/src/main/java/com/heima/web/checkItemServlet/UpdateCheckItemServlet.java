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

@WebServlet("/checkitem/edit.do")
public class UpdateCheckItemServlet extends HttpServlet {

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
        //获取参数
        String _chickItem = request.getReader().readLine();
        CheckItem checkItem = JSON.parseObject(_chickItem, CheckItem.class);

        //调用方法
        int i = checkItemService.updateByOBJ(checkItem);

        //响应数据
        Result result = new Result();
        if(i>0){
            //说明添加修改成功，响应消息
            result.setFlag(true);
            result.setMessage("修改成功");
        }else{
            //修改失败
            result.setFlag(false);
            result.setMessage("修改失败");
        }

        response.getWriter().write(JSON.toJSONString(result));

    }
}
