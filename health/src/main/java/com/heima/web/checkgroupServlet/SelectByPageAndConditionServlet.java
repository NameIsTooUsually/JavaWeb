package com.heima.web.checkgroupServlet;

import com.alibaba.fastjson.JSON;
import com.heima.pojo.CheckGroup;
import com.heima.pojo.PageBean;
import com.heima.pojo.PageBeanResult;
import com.heima.pojo.QueryDTO;
import com.heima.service.CheckGroupService;
import com.heima.service.impl.CheckGroupServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkgroup/findPage.do")
public class SelectByPageAndConditionServlet extends HttpServlet {
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
        String queryDTOStr = request.getReader().readLine();
        QueryDTO queryDTO = JSON.parseObject(queryDTOStr, QueryDTO.class);

        //调用方法
        PageBean<CheckGroup> pageBean = checkGroupService.selectByPageAndCondition(queryDTO);

        //转换成json字符串并响应
        response.getWriter().write(JSON.toJSONString(pageBean));

    }
}
