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

@WebServlet("/checkgroup/add.do")
public class AddGroupServlet extends HttpServlet {
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

        CheckGroup checkGroup = JSON.parseObject(request.getReader().readLine(), CheckGroup.class);
        String _id = request.getParameter("checkitemIds");
        String[] split = _id.split(",");
        int[] ids = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            ids[i] = Integer.parseInt(split[i]);
        }

        //创建对象
        CheckGroupService checkGroupService = new CheckGroupServiceImpl();
        //调用方法
        boolean _result = checkGroupService.addGroup(checkGroup,ids);

        //创建响应数据
        Result result = new Result();
        if(_result){
            //添加成功
            result.setMessage("新增检查组成功");
            result.setFlag(true);
        }else{
            result.setMessage("新增检查失败");
            result.setFlag(false);
        }

        //是指响应
        response.getWriter().write(JSON.toJSONString(result));

    }

}
