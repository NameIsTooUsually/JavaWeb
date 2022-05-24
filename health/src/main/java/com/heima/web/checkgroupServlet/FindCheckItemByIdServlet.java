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
import java.util.List;

@WebServlet("/checkgroup/findCheckItemIdsByCheckGroupId.do")
public class FindCheckItemByIdServlet extends HttpServlet {

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
        int[] ids = checkGroupService.findCheckItemById(Integer.parseInt(checkGroupId));

        Result<int[]> result = new Result<>();
        if(ids.length>0){
            //查找成功
            result.setFlag(true);
            result.setData(ids);

        }else{
            //查找失败
            result.setFlag(false);
            result.setMessage("查询失败");
        }

        //设置响应数据
        response.getWriter().write(JSON.toJSONString(result));
    }
}
