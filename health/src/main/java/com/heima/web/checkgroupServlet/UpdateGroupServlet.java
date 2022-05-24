package com.heima.web.checkgroupServlet;

import com.alibaba.fastjson.JSON;
import com.heima.pojo.CheckGroup;
import com.heima.pojo.Result;
import com.heima.service.CheckGroupService;
import com.heima.service.impl.CheckGroupServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkgroup/findById.do")
public class UpdateGroupServlet extends HttpServlet {
    CheckGroupService checkGroupService = new CheckGroupServiceImpl();
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
        String checkGroupId = request.getParameter("id");

        //调用方法
        CheckGroup checkGroup = checkGroupService.findById(Integer.parseInt(checkGroupId));
        Result<CheckGroup> result = new Result<>();
        if(checkGroup!=null){
            //查询成功
            result.setFlag(true);
            result.setData(checkGroup);
        }else{
            //查询失败
            result.setFlag(false);
            result.setMessage("查询检查组失败");
        }

        //设置响应
        response.getWriter().write(JSON.toJSONString(result));
    }
}
